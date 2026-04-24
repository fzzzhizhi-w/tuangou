package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.StoreupDao;
import com.entity.StoreupEntity;
import com.service.StoreupService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("storeupService")
public class StoreupServiceImpl extends ServiceImpl<StoreupDao, StoreupEntity> implements StoreupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<StoreupEntity> ew) {
        IPage<StoreupEntity> page = this.page(new Query<StoreupEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
