package com.qf.service.impl;


import com.qf.dao.UserDao;
import com.qf.pojo.MyPage;
import com.qf.pojo.Quan;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.repository.UserRepository;
import com.qf.service.UserService;
import com.qf.vo.MyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepository userRepository;


    @Override
    public MyList findAll(Integer page, Integer size) {
        PageRequest of = PageRequest.of((page <= 0 ? 1 : (page - 1)), size);
        PageRequest.of((page <= 0 ? 1 : page - 1), size);

        Page<User> all = userRepository.findAll(of);

        MyList list = new MyList();
        list.setList(all.getContent());
        list.setTotals(all.getTotalElements());
        return list;
    }

    @Override
    public User updateById(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleById(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Override
    public User findOneByname(String name) {

        return userDao.findOneByname(name);
    }

    @Override
    public User findOneById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public Integer addUser(User user, UserAndRole ur) {
        user.setUserstatus(1);
        Integer num = userDao.addUser(user);

        if (num == 1) {
            Integer uid = userDao.findOneByname(user.getName()).getUid();
            ur.setUid(uid);
            ur.setRid(2);
            num = userDao.addRole(ur);
        }
        return num;
    }

    @Override
    public List<Quan> findQuan(String name) {
        return userDao.findQuan(name);
    }
}
