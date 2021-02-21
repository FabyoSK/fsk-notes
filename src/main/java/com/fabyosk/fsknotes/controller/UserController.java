package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping("/user")
    public String getUser(Model model){
        model.addAttribute("user", userRepository.findAll());
        return "user/list";
    }
}
