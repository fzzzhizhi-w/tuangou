package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.NewsEntity;
import com.service.NewsService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, NewsEntity entity) {
        QueryWrapper<NewsEntity> ew = new QueryWrapper<>();
        if (entity.getTitle() != null && !entity.getTitle().isEmpty()) {
            ew.like("title", entity.getTitle());
        }
        MPUtil.sort(ew, params);
        PageUtils page = newsService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, NewsEntity entity) {
        QueryWrapper<NewsEntity> ew = new QueryWrapper<>();
        if (entity.getTitle() != null && !entity.getTitle().isEmpty()) {
            ew.like("title", entity.getTitle());
        }
        MPUtil.sort(ew, params);
        PageUtils page = newsService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", newsService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody NewsEntity entity) {
        entity.setId(new Date().getTime());
        entity.setAddtime(new Date());
        newsService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody NewsEntity entity) {
        newsService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        newsService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
