package com.controller;

import com.pojo.UserEntity;
import com.service.impl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weber on 2017/7/11.
 */

@RestController
public class UserController {
    @Autowired
    userServiceImpl userService;

    @GetMapping("/getuser")
    public UserEntity getUser(){
        UserEntity use=userService.user();
        if( use!=null)
            return use;
        else
            return null;
    }
}
