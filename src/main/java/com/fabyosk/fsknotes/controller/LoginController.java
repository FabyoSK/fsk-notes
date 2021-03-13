package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.services.auth.AuthService;

public class LoginController {
    private AuthService authService;
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
