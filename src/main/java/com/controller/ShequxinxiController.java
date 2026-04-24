package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.ShequxinxiEntity;
import com.service.ShequxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/shequxinxi")
public class ShequxinxiController {

    @Autowired
    private ShequxinxiService shequxinxiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ShequxinxiEntity entity) {
        QueryWrapper<ShequxinxiEntity> ew = new QueryWrapper<>();
        if (entity.getTitle() != null && !entity.getTitle().isEmpty()) {
            ew.like("title", entity.getTitle());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shequxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ShequxinxiEntity entity) {
        QueryWrapper<ShequxinxiEntity> ew = new QueryWrapper<>();
        if (entity.getTitle() != null && !entity.getTitle().isEmpty()) {
            ew.like("title", entity.getTitle());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shequxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", shequxinxiService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody ShequxinxiEntity entity) {
        entity.setId(new Date().getTime());
        entity.setAddtime(new Date());
        shequxinxiService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ShequxinxiEntity entity) {
        shequxinxiService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        shequxinxiService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
