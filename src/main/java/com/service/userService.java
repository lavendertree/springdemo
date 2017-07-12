package com.service;

import com.pojo.UserEntity;

/**
 * Created by weber on 2017/7/11.
 */
public interface userService {

    public void addUser(String username,String password);

    public UserEntity user();
}
