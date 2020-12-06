package com.Userinfo.UserService.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("Could Not find User - " + id);
    }
}
