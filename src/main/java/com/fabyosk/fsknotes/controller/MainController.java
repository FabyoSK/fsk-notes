package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHome(Model model) {
        User fsk = new User();
        fsk.setName("fsk");
        fsk.setPassword("gg");
        fsk.setUsername("fsk");
        model.addAttribute("user", fsk);
        return "index";
    }
}
