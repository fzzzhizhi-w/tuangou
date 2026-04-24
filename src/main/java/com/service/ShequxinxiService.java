package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.ShequxinxiEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface ShequxinxiService extends IService<ShequxinxiEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShequxinxiEntity> ew);
}
