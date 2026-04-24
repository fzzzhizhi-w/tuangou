package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.ShangjiaDao;
import com.entity.ShangjiaEntity;
import com.service.ShangjiaService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("shangjiaService")
public class ShangjiaServiceImpl extends ServiceImpl<ShangjiaDao, ShangjiaEntity> implements ShangjiaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangjiaEntity> ew) {
        IPage<ShangjiaEntity> page = this.page(new Query<ShangjiaEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
