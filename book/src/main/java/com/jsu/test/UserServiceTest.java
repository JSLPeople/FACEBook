package com.jsu.test;

import com.jsu.pojo.User;
import com.jsu.service.UserService;
import com.jsu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"abj168","6666666","asd@qq.com"));
        userService.registUser(new User(null,"vbj168","6666666","amd@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"wzg168","wzg168",null)));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("wzg168")){
            System.out.println("用户名已存在！");
        } else{
            System.out.println("用户名可用！");
        }
    }
}