package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface YonghuService extends IService<YonghuEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<YonghuEntity> ew);
}
