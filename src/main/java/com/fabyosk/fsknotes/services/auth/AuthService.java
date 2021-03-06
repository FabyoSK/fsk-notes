package com.fabyosk.fsknotes.services.auth;

import com.fabyosk.fsknotes.services.user.UserServiceInteface;

public class AuthService implements AuthServiceInterface {
    private UserServiceInteface userService;

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }
}
