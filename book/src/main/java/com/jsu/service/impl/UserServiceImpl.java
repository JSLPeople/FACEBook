package com.jsu.service.impl;

import com.jsu.dao.UserDao;
import com.jsu.dao.impl.UserDaoImpl;
import com.jsu.pojo.User;
import com.jsu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            //等于null，说明没查到，没查到表示可用
            return false;
        }
        return true;



    }
}
