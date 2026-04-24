package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.AddressEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface AddressService extends IService<AddressEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<AddressEntity> ew);
}
