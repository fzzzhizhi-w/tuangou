package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.ShangjiaEntity;
import com.service.ShangjiaService;
import com.service.TokenService;
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
@RequestMapping("/shangjia")
public class ShangjiaController {

    @Autowired
    private ShangjiaService shangjiaService;

    @Autowired
    private TokenService tokenService;

    @IgnoreAuth
    @RequestMapping("/login")
    public R login(String shangjiabianhao, String mima) {
        ShangjiaEntity user = shangjiaService.getOne(
            new QueryWrapper<ShangjiaEntity>()
                .eq("shangjiabianhao", shangjiabianhao)
                .eq("mima", MD5Util.encrypt(mima))
        );
        if (user == null) {
            return R.error("账号或密码不正确");
        }
        if (!"已审核".equals(user.getShenhezt())) {
            return R.error("账号未审核，请等待管理员审核");
        }
        String token = tokenService.generateToken(user.getId(), shangjiabianhao, "shangjia", "商家");
        return R.ok().put("token", token).put("role", "商家").put("userid", user.getId()).put("username", shangjiabianhao);
    }

    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShangjiaEntity entity) {
        ShangjiaEntity exist = shangjiaService.getOne(
            new QueryWrapper<ShangjiaEntity>().eq("shangjiabianhao", entity.getShangjiabianhao())
        );
        if (exist != null) {
            return R.error("商家编号已存在");
        }
        entity.setId(new Date().getTime());
        entity.setMima(MD5Util.encrypt(entity.getMima()));
        entity.setShenhezt("未审核");
        entity.setMoney(0.0);
        entity.setAddtime(new Date());
        shangjiaService.save(entity);
        return R.ok();
    }

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ShangjiaEntity entity) {
        QueryWrapper<ShangjiaEntity> ew = new QueryWrapper<>();
        if (entity.getShangjiamingcheng() != null && !entity.getShangjiamingcheng().isEmpty()) {
            ew.like("shangjiamingcheng", entity.getShangjiamingcheng());
        }
        MPUtil.sort(ew, params);
        PageUtils page = shangjiaService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", shangjiaService.getById(id));
    }

    @RequestMapping("/save")
    public R save(@RequestBody ShangjiaEntity entity) {
        entity.setId(new Date().getTime());
        entity.setMima(MD5Util.encrypt(entity.getMima()));
        entity.setAddtime(new Date());
        shangjiaService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ShangjiaEntity entity) {
        if (entity.getMima() != null && !entity.getMima().isEmpty()) {
            entity.setMima(MD5Util.encrypt(entity.getMima()));
        }
        shangjiaService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        shangjiaService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        ShangjiaEntity user = shangjiaService.getById(userId);
        return R.ok().put("data", user);
    }
}
