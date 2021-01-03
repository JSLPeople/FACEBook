package com.jsu.test;

import com.jsu.dao.UserDao;
import com.jsu.dao.impl.UserDaoImpl;
import com.jsu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

       if(userDao.queryUserByUsername("admin") == null){
           System.out.println("用户名可用！");
       } else{
           System.out.println("用户名已存在！");
       }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        } else{
            System.out.println("查询成功！");
        }
    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null,"lts168","1234567","wzg133@qq.com")));

    }
}