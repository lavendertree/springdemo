package com.service.impl;

import com.dao.UserDao;
import com.pojo.UserEntity;
import com.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by weber on 2017/7/11.
 */
@Service("userService")
public class userServiceImpl implements userService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(String username,String password) {
        UserEntity user=new UserEntity();
        user.setUsername(username);
        user.setPassword(new StandardPasswordEncoder().encode(password));
        userDao.save(user);
    }

    @Override
    public UserEntity user() {
        return userDao.findOne("qw");
    }
}
