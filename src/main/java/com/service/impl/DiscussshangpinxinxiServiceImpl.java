package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.DiscussshangpinxinxiDao;
import com.entity.DiscussshangpinxinxiEntity;
import com.service.DiscussshangpinxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("discussshangpinxinxiService")
public class DiscussshangpinxinxiServiceImpl extends ServiceImpl<DiscussshangpinxinxiDao, DiscussshangpinxinxiEntity> implements DiscussshangpinxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscussshangpinxinxiEntity> ew) {
        IPage<DiscussshangpinxinxiEntity> page = this.page(new Query<DiscussshangpinxinxiEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
