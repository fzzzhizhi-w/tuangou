package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.UsersEntity;
import com.service.TokenService;
import com.service.UsersService;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TokenService tokenService;

    @IgnoreAuth
    @RequestMapping("/login")
    public R login(String username, String password) {
        UsersEntity user = usersService.getOne(
            new QueryWrapper<UsersEntity>()
                .eq("username", username)
                .eq("password", MD5Util.encrypt(password))
        );
        if (user == null) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(), username, "users", user.getRole());
        return R.ok().put("token", token).put("role", user.getRole()).put("userid", user.getId()).put("username", username);
    }

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, UsersEntity entity) {
        QueryWrapper<UsersEntity> ew = new QueryWrapper<>();
        if (entity.getUsername() != null && !entity.getUsername().isEmpty()) {
            ew.like("username", entity.getUsername());
        }
        MPUtil.sort(ew, params);
        PageUtils page = usersService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        return R.ok().put("data", usersService.getById(id));
    }

    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody UsersEntity entity) {
        UsersEntity exist = usersService.getOne(
            new QueryWrapper<UsersEntity>().eq("username", entity.getUsername())
        );
        if (exist != null) {
            return R.error("用户名已存在");
        }
        entity.setId(new Date().getTime());
        entity.setPassword(MD5Util.encrypt(entity.getPassword()));
        entity.setAddtime(new Date());
        usersService.save(entity);
        return R.ok();
    }

    @RequestMapping("/save")
    public R save(@RequestBody UsersEntity entity) {
        entity.setId(new Date().getTime());
        entity.setPassword(MD5Util.encrypt(entity.getPassword()));
        entity.setAddtime(new Date());
        usersService.save(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity entity) {
        if (entity.getPassword() != null && !entity.getPassword().isEmpty()) {
            entity.setPassword(MD5Util.encrypt(entity.getPassword()));
        }
        usersService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        usersService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        UsersEntity user = usersService.getOne(
            new QueryWrapper<UsersEntity>().eq("username", username)
        );
        if (user == null) {
            return R.error("用户不存在");
        }
        user.setPassword(MD5Util.encrypt("123456"));
        usersService.updateById(user);
        return R.ok();
    }
}
