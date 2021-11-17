package com.otpproject.config.service;

import com.otpproject.config.exception.AttemptsExceededException;
import com.otpproject.config.exception.OtpExpiredException;
import com.otpproject.config.exception.OtpInvalidException;
import com.otpproject.config.exception.UsernameNotFoundException;

public interface OtpService {
	public int generateOTP(String userName) throws UsernameNotFoundException, AttemptsExceededException;
	public String validateOTP(String userName,int otp) throws UsernameNotFoundException, OtpInvalidException, OtpExpiredException;
}
