package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.ShangjiaEntity;
import com.utils.PageUtils;
import java.util.Map;

public interface ShangjiaService extends IService<ShangjiaEntity> {
    PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangjiaEntity> ew);
}
