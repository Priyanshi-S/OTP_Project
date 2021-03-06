package com.otpproject.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.otpproject.config.exception.AttemptsExceededException;
import com.otpproject.config.exception.OtpExpiredException;
import com.otpproject.config.exception.OtpInvalidException;
import com.otpproject.config.exception.UsernameNotFoundException;
import com.otpproject.config.service.OtpService;


@RestController
@RequestMapping("/api")
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	OtpService service;
	
	@PostMapping("/generateOTP/{userName}")
	public int generateOTP(@PathVariable String userName) throws UsernameNotFoundException,OtpExpiredException, AttemptsExceededException
	{
		LOGGER.info("Generating OTP Purpose");
		return service.generateOTP(userName);
	}
	
	@GetMapping("/validateOTP/{userName}/{otp}")
	public String validateOTP(@PathVariable String userName, @PathVariable int otp) throws UsernameNotFoundException,OtpInvalidException,OtpExpiredException
	{
		LOGGER.info("Validating OTP Purpose");
		return service.validateOTP(userName,otp);
	}
	
	
}
