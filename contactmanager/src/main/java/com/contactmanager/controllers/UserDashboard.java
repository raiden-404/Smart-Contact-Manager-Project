package com.contactmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserDashboard {
    
    @RequestMapping("/index")
    public String dashboard() {
        return "user/index";
    }
    
}
