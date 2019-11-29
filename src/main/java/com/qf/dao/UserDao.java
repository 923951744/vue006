package com.qf.dao;

import com.qf.pojo.MyPage;
import com.qf.pojo.Quan;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User findOneByname(String name);



    List<Quan> findQuan(String name);


    Integer addUser(User user);

    Integer addRole(UserAndRole ur);
}
