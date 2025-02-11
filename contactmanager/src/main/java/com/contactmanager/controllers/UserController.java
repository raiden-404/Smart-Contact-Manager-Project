package com.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contactmanager.entities.User;
import com.contactmanager.helperClass.JpaRepo;

//controller to handle all the HTTP pattern from user
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    JpaRepo jpaRepo;

    // index page-starting page for user
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {

        // getting the unique username of user
        String username = principal.getName();
        System.out.println(username);

        // using that user name fetch data from database
        User user = jpaRepo.getUserByUsername(username);
        System.out.println(user);

        // add in model to use in template
        model.addAttribute("user", user);
        model.addAttribute("title", "User Dashboard");

        // return the html page
        return "user/index";
    }

}
