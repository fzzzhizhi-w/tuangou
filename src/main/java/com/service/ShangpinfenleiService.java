package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.ShangpinfenleiEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface ShangpinfenleiService extends IService<ShangpinfenleiEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangpinfenleiEntity> ew);
}
