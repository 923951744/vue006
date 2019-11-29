package com.qf.controller;


import com.qf.pojo.MyPage;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.service.UserService;
import com.qf.vo.MyList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Integer login(User user) {

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPass());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("/all")
    public MyList findAll(Integer page, Integer size) {


        MyList all = userService.findAll(page, size);

        return all;
    }

    @RequestMapping("/one")
    public User findOne(Integer uid) {


        User one = userService.findOneById(uid);
        if (one != null) {
            return one;
        }

        return null;
    }

    Integer cc = 100;
    int bb = 3;

    @RequestMapping("/add")
    public Integer add(@RequestBody User user) {


        UserAndRole ur = new UserAndRole();

        return userService.addUser(user, ur);
    }

    @RequiresPermissions(value = {"/del"})
    @RequestMapping("/update")
    public User updateById(@RequestBody User user) {

        User us = userService.updateById(user);
        if (us != null) {
            return us;
        }
        return null;
    }

    @RequiresPermissions(value = {"/del"})
    @RequestMapping("/delOne")
    public void updateById(Integer uid) {
        userService.deleById(uid);

    }

}
