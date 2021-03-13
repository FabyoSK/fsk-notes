package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.auth.AuthService;
import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private AuthService authService;
    private UserServices userServices;

    @Autowired
    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String getUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        userServices.add(user);
        return "user/register_success";
    }
}
