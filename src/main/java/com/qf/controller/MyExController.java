package com.qf.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExController {
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public String ss() {
        return "权限不足";
    }

}
