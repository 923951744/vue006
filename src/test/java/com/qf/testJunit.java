package com.qf;

import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testJunit {
    @Autowired
    private UserService userService;

    @Test
    public void aa() {
        UserServiceImpl us=new UserServiceImpl();
       // us.findAll2(1,3);
    }
}
