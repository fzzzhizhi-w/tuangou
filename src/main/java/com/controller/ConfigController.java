package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.ConfigEntity;
import com.service.ConfigService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @IgnoreAuth
    @RequestMapping("/info")
    public R info(String name) {
        ConfigEntity entity = configService.getOne(
            new QueryWrapper<ConfigEntity>().eq("name", name)
        );
        return R.ok().put("data", entity);
    }

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ConfigEntity entity) {
        QueryWrapper<ConfigEntity> ew = new QueryWrapper<>();
        if (entity.getName() != null && !entity.getName().isEmpty()) {
            ew.like("name", entity.getName());
        }
        MPUtil.sort(ew, params);
        PageUtils page = configService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ConfigEntity entity) {
        QueryWrapper<ConfigEntity> ew = new QueryWrapper<>();
        MPUtil.sort(ew, params);
        PageUtils page = configService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/save")
    public R save(@RequestBody ConfigEntity entity) {
        entity.setId(new Date().getTime());
        configService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ConfigEntity entity) {
        configService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        configService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
