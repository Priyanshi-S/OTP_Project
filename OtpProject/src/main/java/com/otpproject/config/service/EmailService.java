package com.otpproject.config.service;


public interface EmailService {
	public void sendMail(String to, String subject, int text);
}
