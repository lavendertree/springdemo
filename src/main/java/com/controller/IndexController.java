package com.controller;

import com.service.impl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by weber on 2017/7/10.
 */
@Controller
public class IndexController {

    @Autowired
    userServiceImpl userService;

    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/register";
    }


    @PostMapping(value = "/register")
    public String register(String username, String password, Model model){
        userService.addUser(username,password);
        model.addAttribute("result",true);
        return "/index";
    }
}
