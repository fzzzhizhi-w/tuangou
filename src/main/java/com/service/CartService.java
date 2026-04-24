package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.CartEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface CartService extends IService<CartEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<CartEntity> ew);
}
