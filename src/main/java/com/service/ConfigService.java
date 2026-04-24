package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.ConfigEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface ConfigService extends IService<ConfigEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<ConfigEntity> ew);
}
