package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.YonghuEntity;
import com.service.TokenService;
import com.service.YonghuService;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.*;

@RestController
@RequestMapping("/yonghu")
public class YonghuController {

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private TokenService tokenService;

    @IgnoreAuth
    @RequestMapping("/login")
    public R login(String zhanghao, String mima) {
        YonghuEntity user = yonghuService.getOne(
            new QueryWrapper<YonghuEntity>()
                .eq("zhanghao", zhanghao)
                .eq("mima", MD5Util.encrypt(mima))
        );
        if (user == null) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(), zhanghao, "yonghu", "用户");
        return R.ok().put("token", token).put("role", "用户").put("userid", user.getId()).put("username", zhanghao);
    }

    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YonghuEntity entity) {
        YonghuEntity exist = yonghuService.getOne(
            new QueryWrapper<YonghuEntity>().eq("zhanghao", entity.getZhanghao())
        );
        if (exist != null) {
            return R.error("账号已存在");
        }
        entity.setId(new Date().getTime());
        entity.setMima(MD5Util.encrypt(entity.getMima()));
        entity.setMoney(0.0);
        entity.setAddtime(new Date());
        yonghuService.save(entity);
        return R.ok();
    }

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YonghuEntity entity) {
        QueryWrapper<YonghuEntity> ew = new QueryWrapper<>();
        if (entity.getZhanghao() != null && !entity.getZhanghao().isEmpty()) {
            ew.like("zhanghao", entity.getZhanghao());
        }
        if (entity.getXingming() != null && !entity.getXingming().isEmpty()) {
            ew.like("xingming", entity.getXingming());
        }
        MPUtil.sort(ew, params);
        PageUtils page = yonghuService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", yonghuService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody YonghuEntity entity) {
        entity.setId(new Date().getTime());
        entity.setMima(MD5Util.encrypt(entity.getMima()));
        entity.setAddtime(new Date());
        yonghuService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody YonghuEntity entity) {
        if (entity.getMima() != null && !entity.getMima().isEmpty()) {
            entity.setMima(MD5Util.encrypt(entity.getMima()));
        }
        yonghuService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yonghuService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        YonghuEntity user = yonghuService.getById(userId);
        return R.ok().put("data", user);
    }
}
