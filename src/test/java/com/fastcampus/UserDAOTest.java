package com.fastcampus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserDAO;

@SpringBootTest
class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	void userTest() {
		User user = new User();
		user.setId(6);
		user.setUsername("guest");
		user.setPassword("guest123");
		user.setEmail("guest@naver.com");
		
		int beforeSize = userDAO.getUserList().size();
		userDAO.insertUser(user);
		int afterSize = userDAO.getUserList().size();
		assertEquals(beforeSize + 1, afterSize);
	}

}
