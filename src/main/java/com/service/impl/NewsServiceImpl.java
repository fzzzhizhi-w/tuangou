package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.NewsDao;
import com.entity.NewsEntity;
import com.service.NewsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<NewsEntity> ew) {
        IPage<NewsEntity> page = this.page(new Query<NewsEntity>().getPage(params), ew);
        return new PageUtils(page);
    }
}
