package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.TokenDao;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.CommonUtil;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;

@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

    @Override
    public TokenEntity getTokenEntity(String token) {
        TokenEntity tokenEntity = this.getOne(
            new QueryWrapper<TokenEntity>().eq("token", token)
        );
        if (tokenEntity != null) {
            if (tokenEntity.getExpiratedtime().before(new Date())) {
                this.removeById(tokenEntity.getId());
                return null;
            }
        }
        return tokenEntity;
    }

    @Override
    public String generateToken(Long userid, String username, String tablename, String role) {
        TokenEntity tokenEntity = this.getOne(
            new QueryWrapper<TokenEntity>()
                .eq("userid", userid)
                .eq("tablename", tablename)
        );
        String token = CommonUtil.getToken();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date expiratedTime = calendar.getTime();

        if (tokenEntity == null) {
            tokenEntity = new TokenEntity();
            tokenEntity.setId(new Date().getTime());
            tokenEntity.setUserid(userid);
            tokenEntity.setUsername(username);
            tokenEntity.setTablename(tablename);
            tokenEntity.setRole(role);
            tokenEntity.setToken(token);
            tokenEntity.setExpiratedtime(expiratedTime);
            tokenEntity.setAddtime(new Date());
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setExpiratedtime(expiratedTime);
            this.updateById(tokenEntity);
        }
        return token;
    }
}
