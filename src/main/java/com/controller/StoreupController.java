package com.controller;

import com.entity.StoreupEntity;
import com.service.StoreupService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/storeup")
public class StoreupController {

    @Autowired
    private StoreupService storeupService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StoreupEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<StoreupEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        if (entity.getTablename() != null && !entity.getTablename().isEmpty()) {
            ew.eq("tablename", entity.getTablename());
        }
        MPUtil.sort(ew, params);
        PageUtils page = storeupService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, StoreupEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        QueryWrapper<StoreupEntity> ew = new QueryWrapper<>();
        if (userId != null) {
            ew.eq("userid", userId);
        }
        MPUtil.sort(ew, params);
        PageUtils page = storeupService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", storeupService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        StoreupEntity exist = storeupService.getOne(
            new QueryWrapper<StoreupEntity>()
                .eq("userid", userId)
                .eq("refid", entity.getRefid())
                .eq("tablename", entity.getTablename())
        );
        if (exist != null) {
            return R.error("已收藏");
        }
        entity.setId(new Date().getTime());
        entity.setUserid(userId);
        entity.setAddtime(new Date());
        storeupService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody StoreupEntity entity) {
        storeupService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        storeupService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
