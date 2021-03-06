package com.fabyosk.fsknotes.services.auth;

public interface AuthServiceInterface {
    /**
     * Authenticates the user using the given username and password
     *
     * @param username the user name
     * @param password the user password
     * @return true if authenticated
     */
    boolean authenticate(String username, String password);
}

