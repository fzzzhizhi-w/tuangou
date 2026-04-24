package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.YonghuDao;
import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("yonghuService")
public class YonghuServiceImpl extends ServiceImpl<YonghuDao, YonghuEntity> implements YonghuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YonghuEntity> ew) {
        IPage<YonghuEntity> page = this.page(new Query<YonghuEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
