package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.ShequxinxiDao;
import com.entity.ShequxinxiEntity;
import com.service.ShequxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("shequxinxiService")
public class ShequxinxiServiceImpl extends ServiceImpl<ShequxinxiDao, ShequxinxiEntity> implements ShequxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShequxinxiEntity> ew) {
        IPage<ShequxinxiEntity> page = this.page(new Query<ShequxinxiEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
