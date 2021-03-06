package com.otpproject.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{
	 	
		@Autowired
	    private JavaMailSender emailSender;

	    public void sendMail(String to, String subject, int text) {

	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("reshuj819@gmail.com");
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText("Otp is valid for 5 minutes! OTP is:"+Integer.toString(text));
	        emailSender.send(message);

	    }
}
