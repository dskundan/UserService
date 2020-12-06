package com.Userinfo.UserService.restService;

import com.Userinfo.UserService.dao.User;
import com.Userinfo.UserService.services.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user/")
@Slf4j
public class UserController {
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * Constructor Initialization.
     *
     * @param userService
     */
    public UserController(final UserService userService) {

        this.userService = userService;
    }

    /**
     * Get all users endpoint.
     * @return
     */
    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        log.info("Retriving all the users - Started");
        List<User> allUsers = userService.getAllUsers();
        log.info("Retriving all the users- Completed");
        return allUsers;
    }

    /**
     * Get specific user
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public User getUser(@PathVariable final String id) {
        log.info("Fetch user details for [{}] - Started ", id);
        User user = userService.getUser(id);
        log.info("Fetch user details for [{}] - Finished ", id);
        return user;
    }

    /**
     * add user endpoint.
     * @param user
     * @return
     */
    @PostMapping("addUser")
    @ApiOperation(value = "add user method")
    public User createUser(@Valid @RequestBody final User user) {
        log.info("AddUser Request came for User [{}]", user.getFirstName());
        User saveUser = userService.addUser(user);
        log.info("User [{}] has been added Successfully to db ", user.getFirstName());
        return saveUser;

    }
}