package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.StoreupEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface StoreupService extends IService<StoreupEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<StoreupEntity> ew);
}
