package com.Userinfo.UserService.services;

import com.Userinfo.UserService.dao.User;
import com.Userinfo.UserService.dao.UserRepository;
import com.Userinfo.UserService.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Constructor Intialization.
     * @param userRepository
     */
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method to add User
     * @param user
     * @return
     */
    @Override
    public User addUser(final User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    /**
     * Method to fetch user.
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Method to get a specific user.
     * @param id
     * @return
     */
    @Override
    public User getUser(final String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
