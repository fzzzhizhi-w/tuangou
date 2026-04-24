package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.ShangpinxinxiDao;
import com.entity.ShangpinxinxiEntity;
import com.service.ShangpinxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("shangpinxinxiService")
public class ShangpinxinxiServiceImpl extends ServiceImpl<ShangpinxinxiDao, ShangpinxinxiEntity> implements ShangpinxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangpinxinxiEntity> ew) {
        IPage<ShangpinxinxiEntity> page = this.page(new Query<ShangpinxinxiEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
