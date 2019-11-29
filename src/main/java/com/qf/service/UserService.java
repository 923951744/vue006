package com.qf.service;

import com.qf.pojo.MyPage;
import com.qf.pojo.Quan;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.vo.MyList;

import java.util.List;

public interface UserService {
    MyList findAll(Integer page, Integer size);

    User updateById(User user);

    void deleById(Integer uid);

    User findOneByname(String name);

    User findOneById(Integer uid);

    Integer addUser(User user, UserAndRole ur);

    List<Quan> findQuan(String name);
}
