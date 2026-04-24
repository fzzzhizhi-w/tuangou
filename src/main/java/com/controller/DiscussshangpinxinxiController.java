package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.DiscussshangpinxinxiEntity;
import com.service.DiscussshangpinxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/discussshangpinxinxi")
public class DiscussshangpinxinxiController {

    @Autowired
    private DiscussshangpinxinxiService discussshangpinxinxiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscussshangpinxinxiEntity entity) {
        QueryWrapper<DiscussshangpinxinxiEntity> ew = new QueryWrapper<>();
        if (entity.getRefid() != null) {
            ew.eq("refid", entity.getRefid());
        }
        MPUtil.sort(ew, params);
        PageUtils page = discussshangpinxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussshangpinxinxiEntity entity) {
        QueryWrapper<DiscussshangpinxinxiEntity> ew = new QueryWrapper<>();
        if (entity.getRefid() != null) {
            ew.eq("refid", entity.getRefid());
        }
        MPUtil.sort(ew, params);
        PageUtils page = discussshangpinxinxiService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", discussshangpinxinxiService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody DiscussshangpinxinxiEntity entity, HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        entity.setId(new Date().getTime());
        entity.setUserid(userId);
        entity.setAddtime(new Date());
        discussshangpinxinxiService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody DiscussshangpinxinxiEntity entity) {
        discussshangpinxinxiService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        discussshangpinxinxiService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
