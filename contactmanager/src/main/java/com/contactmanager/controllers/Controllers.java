package com.contactmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controllers {
    //Home page Handler
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("title","Home");
        return "home";
    }

    //about page Handler
    @GetMapping("/about")
    public String aboutMe(Model model) {
        model.addAttribute("title","About Me");
        return "about";
    }

    //Signup page Handler
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register");
        return "signup";
    }

    //Login page Handler
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Login");
        return "login";
    }
}
