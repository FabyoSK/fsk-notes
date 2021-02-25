package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.repositories.UserRepository;
import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userRepository;
    private UserServices userServices = new UserServices();

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String getUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        System.out.println(user);
        userServices.setCurrentUser(user);
        userServices.addUser(user);
        userRepository.save(user);
        model.addAttribute("users", userServices.findAll());
        return "user/register_success";
    }


}
