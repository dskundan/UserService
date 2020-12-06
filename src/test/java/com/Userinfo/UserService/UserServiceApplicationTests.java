package com.Userinfo.UserService;

import com.Userinfo.UserService.restService.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception{
		assertThat(userController).isNotNull();
	}

}
