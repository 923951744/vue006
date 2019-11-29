package com.qf.vo;

import com.qf.pojo.User;
import lombok.Data;

import java.util.List;

@Data
public class MyList {
    List<User> list;
    Long totals;
}
