package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.ShangpinxinxiEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface ShangpinxinxiService extends IService<ShangpinxinxiEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangpinxinxiEntity> ew);
}
