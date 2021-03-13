package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServices userService;





    public void setUserService(UserServices userService) {
        this.userService = userService;
    }


}
