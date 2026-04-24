package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.TokenEntity;

public interface TokenService extends IService<TokenEntity> {
    TokenEntity getTokenEntity(String token);
    String generateToken(Long userid, String username, String tablename, String role);
}
