package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.ShangpinxinxiEntity;
import com.service.ShangpinxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/shangpinxinxi")
public class ShangpinxinxiController {

    @Autowired
    private ShangpinxinxiService shangpinxinxiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ShangpinxinxiEntity entity, HttpServletRequest request) {
        QueryWrapper<ShangpinxinxiEntity> ew = new QueryWrapper<>();
        String role = (String) request.getSession().getAttribute("role");
        if ("商家".equals(role)) {
            Long userId = (Long) request.getSession().getAttribute("userId");
            ew.eq("shangpubianhao", userId);
        }
        if (entity.getShangpinmingcheng() != null && !entity.getShangpinmingcheng().isEmpty()) {
            ew.like("shangpinmingcheng", entity.getShangpinmingcheng());
        }
        if (entity.getShangpinfenlei() != null && !entity.getShangpinfenlei().isEmpty()) {
            ew.eq("shangpinfenlei", entity.getShangpinfenlei());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shangpinxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ShangpinxinxiEntity entity) {
        QueryWrapper<ShangpinxinxiEntity> ew = new QueryWrapper<>();
        if (entity.getShangpinmingcheng() != null && !entity.getShangpinmingcheng().isEmpty()) {
            ew.like("shangpinmingcheng", entity.getShangpinmingcheng());
        }
        if (entity.getShangpinfenlei() != null && !entity.getShangpinfenlei().isEmpty()) {
            ew.eq("shangpinfenlei", entity.getShangpinfenlei());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shangpinxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ShangpinxinxiEntity entity = shangpinxinxiService.getById(id);
        if (entity != null) {
            entity.setClicknum(entity.getClicknum() == null ? 1 : entity.getClicknum() + 1);
            entity.setClicktime(new Date());
            shangpinxinxiService.updateById(entity);
        }
        return R.ok().put("data", entity);
    }

    @RequestMapping("/save")
    public R save(@RequestBody ShangpinxinxiEntity entity) {
        entity.setId(new Date().getTime());
        entity.setClicknum(0);
        entity.setThumbsupnum(0);
        entity.setCrazilynum(0);
        entity.setCurpeople(0);
        entity.setAddtime(new Date());
        shangpinxinxiService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ShangpinxinxiEntity entity) {
        shangpinxinxiService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        shangpinxinxiService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @IgnoreAuth
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") Long id) {
        ShangpinxinxiEntity entity = shangpinxinxiService.getById(id);
        if (entity != null) {
            entity.setThumbsupnum(entity.getThumbsupnum() == null ? 1 : entity.getThumbsupnum() + 1);
            shangpinxinxiService.updateById(entity);
        }
        return R.ok();
    }
}
