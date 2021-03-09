package com.fabyosk.fsknotes.services.auth;

import com.fabyosk.fsknotes.services.user.UserServiceInteface;
import com.fabyosk.fsknotes.services.user.UserServices;

public class AuthService implements AuthServiceInterface {
    private UserServices userService;

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    public void setUserService(UserServices userService) {
        this.userService = userService;
    }
}
