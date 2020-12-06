package com.Userinfo.UserService.services;

import com.Userinfo.UserService.dao.User;

import java.util.List;

public interface UserService {
    User addUser(final User user);

    List<User> getAllUsers();

    User getUser(final String id);
}
