package com.otpproject.config.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.otpproject.config.OtpPojectApplication;
import com.otpproject.config.dao.UserDao;
import com.otpproject.config.entity.Users;
import com.otpproject.config.exception.UsernameNotFoundException;

@SpringBootTest(classes = OtpPojectApplication.class)
class OtpServiceImplTest {

	@Autowired
	UserDao userDao; 
	
	Users user;
	
	private OtpServiceImpl underTest;
	
	
	@BeforeEach
	void setUp()
	{
		underTest= new OtpServiceImpl();
	}
	
	@Test
	void testGenerateOTP_userFound() {
		Users user=userDao.findById("priyanshi").get();
		assertEquals("priyanshi.18bit1004@abes.ac.in", user.getEmailId());
        assertEquals("UP", user.getState());
        return;
	}
	
	/*
	 * @Test void testGenerate_OtpGenerate() { String actual= user }
	 */
	
//	@Test
//	void testGenerateOTP_userNotFound(){
//	//	Throwable exception =
//				assertThrows(Exception.class, () -> {
//			user=userDao.findById("a").get();
//	    });
////		assertEquals("Invalid UserName : a", exception.getMessage());   
//	}
//
//	@Disabled
//	@Test
//	void testValidateOTP() {
//		fail("Not yet implemented");
//	}

}
