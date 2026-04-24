package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.ShangpinfenleiEntity;
import com.service.ShangpinfenleiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/shangpinfenlei")
public class ShangpinfenleiController {

    @Autowired
    private ShangpinfenleiService shangpinfenleiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ShangpinfenleiEntity entity) {
        QueryWrapper<ShangpinfenleiEntity> ew = new QueryWrapper<>();
        if (entity.getShangpinfenlei() != null && !entity.getShangpinfenlei().isEmpty()) {
            ew.like("shangpinfenlei", entity.getShangpinfenlei());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shangpinfenleiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ShangpinfenleiEntity entity) {
        QueryWrapper<ShangpinfenleiEntity> ew = new QueryWrapper<>();
        MPUtil.sort(ew, params);
        PageUtils page = shangpinfenleiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", shangpinfenleiService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody ShangpinfenleiEntity entity) {
        entity.setId(new Date().getTime());
        entity.setAddtime(new Date());
        shangpinfenleiService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ShangpinfenleiEntity entity) {
        shangpinfenleiService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        shangpinfenleiService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
