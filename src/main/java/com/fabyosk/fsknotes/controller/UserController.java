package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String getUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println(user);
        userRepository.save(user);
        return "register_success";
    }


}
