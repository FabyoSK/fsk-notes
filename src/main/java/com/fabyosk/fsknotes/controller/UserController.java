package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.repositories.UserRepositorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserRepositorie userRepositorie;

    public UserController(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }
    @RequestMapping("/user")
    public String getUser(Model model){
        model.addAttribute("user", userRepositorie.findAll());
        return "user";
    }
}
