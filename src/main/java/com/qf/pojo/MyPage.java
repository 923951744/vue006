package com.qf.pojo;

import lombok.Data;

@Data
public class MyPage {
    private Integer size;//每行显示多少条
    private Integer sizes;//总条数
    private Integer page;//当前页
    private Integer pages;//总页数
    private Integer start;//总页数
}
