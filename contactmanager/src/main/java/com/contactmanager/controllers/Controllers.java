package com.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.contactmanager.entities.User;
import com.contactmanager.helperClass.JpaRepo;
import com.contactmanager.helperClass.MessageValid;
import com.contactmanager.helperClass.Validator;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    JpaRepo jpaRepo;
    @Autowired
    Validator validator;
    @Autowired
    MessageValid messageValid;

    // Home page Handler
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    // about page Handler
    @GetMapping("/about")
    public String aboutMe(Model model) {
        model.addAttribute("title", "About Me");
        return "about";
    }

    // Signup page Handler
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("user", new User());
        return "signup";
    }

    // Login page Handler
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    // doSignUp Handler
    @PostMapping("/doSignup")
    public String doSignup(@ModelAttribute("user") User user, Model model,
            @RequestParam(value = "agreed", defaultValue = "false") boolean agreed, HttpSession session) {

        try {
            if (!agreed) {
                throw new Exception("You must agree to the terms and conditions.");
            }
            messageValid = validator.checkValidation(user);
            if (messageValid.isValid()) {

                // setting all remaining fields
                user.setEnabled(true);
                user.setImage("defultProfile.jpg");
                user.setRole("ROLE_USER");
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                User resultUser = jpaRepo.save(user);
                System.out.println(resultUser);
                session.setAttribute("successMessage", "User Registerd Successfully !!");
            } else {
                session.setAttribute("errorMessage", messageValid.getMessage());
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "signup";
    }

}
