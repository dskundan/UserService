package com.Userinfo.UserService.configuration;

import com.Userinfo.UserService.constants.UserServiceConstants;
import com.Userinfo.UserService.dao.*;
import com.Userinfo.UserService.restService.UserController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
@Slf4j
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Bean
    CommandLineRunner initDB(UserRepository userRepository) {
        return args -> {
            IntStream.rangeClosed(1, 8).forEach(i -> {
                log.info(UserServiceConstants.PRELOADING + userRepository.save(getUser()));
            });
        };
    }

    private User getUser() {
        Random random = new Random();
        String userID = String.valueOf(random.nextInt(9999));
        Address address = new Address(userID, UserServiceConstants.STREET, UserServiceConstants.CITY,
                UserServiceConstants.STATE, UserServiceConstants.POST_CODE);
        User user = new User(userID, Title.Master, UserServiceConstants.FIRST_NAME.concat(userID), UserServiceConstants.LAST_NAME, Gender.Male, UserServiceConstants.EMPLOYEE_ID.concat(userID));
        user.setAddress(address);
        return user;
    }
}
