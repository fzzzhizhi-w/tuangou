package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.OrdersEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface OrdersService extends IService<OrdersEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<OrdersEntity> ew);
}
