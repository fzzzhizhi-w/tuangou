package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.ShangpinfenleiDao;
import com.entity.ShangpinfenleiEntity;
import com.service.ShangpinfenleiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("shangpinfenleiService")
public class ShangpinfenleiServiceImpl extends ServiceImpl<ShangpinfenleiDao, ShangpinfenleiEntity> implements ShangpinfenleiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ShangpinfenleiEntity> ew) {
        IPage<ShangpinfenleiEntity> page = this.page(new Query<ShangpinfenleiEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
