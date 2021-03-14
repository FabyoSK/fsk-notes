package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{username}")
public class UserController {
    private UserServices userService;


    @Autowired
    public void setUserService(UserServices userService) {
        this.userService = userService;
    }


    @GetMapping("/profile")
    public String showProfile(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findByName(username));
        return "user/profile";
    }
}
