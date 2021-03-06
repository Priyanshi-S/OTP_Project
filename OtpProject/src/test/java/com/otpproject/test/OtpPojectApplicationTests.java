package com.otpproject.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.otpproject.config.OtpPojectApplication;
import com.otpproject.config.controller.HomeController;
import com.otpproject.config.dao.UserDao;
import com.otpproject.config.entity.Users;
import com.otpproject.config.service.EmailService;
import com.otpproject.config.service.EmailServiceImpl;
import com.otpproject.config.service.OtpServiceImpl;


@SpringBootTest(classes = OtpPojectApplication.class)
class OtpPojectApplicationTests {
	@Autowired
	UserDao userDao;

	@Test
	public void testReadAll () {
		List list = userDao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testCreate () {
		Users u = new Users();
		u.setUserName("kavya");
		u.setEmailId("kavya@gmail.com");
		u.setAttempts(1);
		u.setOtp(0);
		u.setState("UP");
		userDao.save(u);
		assertNotNull(userDao.findById("kavya").get());
	}
	
	@Test
	public void findById() {
		String emailId= userDao.findById("priyanshi").get().getEmailId();
		assertEquals("priyanshi.18bit1004@abes.ac.in", emailId);
	}

	
}
