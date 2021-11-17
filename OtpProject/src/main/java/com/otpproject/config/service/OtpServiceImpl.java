package com.otpproject.config.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.otpproject.config.dao.UserDao;
import com.otpproject.config.entity.Users;
import com.otpproject.config.exception.AttemptsExceededException;
import com.otpproject.config.exception.OtpExpiredException;
import com.otpproject.config.exception.OtpInvalidException;
import com.otpproject.config.exception.UsernameNotFoundException;
//import com.otpproject.config.service;

@Service
public class OtpServiceImpl implements OtpService{
	
	@Autowired
	UserDao dao;
	
	@Autowired
	public EmailService emailService;
	
	@Value("${my.attemptsTime}")
	private int attemptsTime;
	
	@Value("${my.otpTime}")
	private int otpTime;
	
	@Override
	public int generateOTP(String userName)throws UsernameNotFoundException, AttemptsExceededException {
		// TODO Auto-generated method stub
		
		Users userfind= dao.findById(userName).orElseThrow(() -> new UsernameNotFoundException("Invalid UserName : " + userName));
		
		if (userfind.getAttempts()>0) {
			userfind.setAttempts(userfind.getAttempts()-1);
			Timer timer = new Timer();  
			TimerTask timerTask = new TimerTask()  {  
			    @Override  
			    public void run() { 
			        userfind.setAttempts(userfind.getAttempts()+1);
			        dao.save(userfind);
			    };  
			};  
			timer.schedule(timerTask, attemptsTime);  
			int otp=100000+(new Random().nextInt(900000));
			userfind.setOtp(otp);
			userfind.setTime(LocalDateTime.now());
			System.out.println(userfind.getEmailId());
			dao.save(userfind);
			emailService.sendMail(userfind.getEmailId(), "OTP", userfind.getOtp());
	
			Timer t = new Timer();  
			TimerTask tt = new TimerTask()  {  
			    @Override  
			    public void run() { 
			        userfind.setOtp(0);
			        dao.save(userfind);
			    };  
			};  
			t.schedule(tt, otpTime);  
			return otp;
		}
		else {
			throw new AttemptsExceededException("Attempts To Request For OTP is Exceeded!!");
		}
	}

	@Override
	public String validateOTP(String userName, int otp) throws UsernameNotFoundException,OtpInvalidException,OtpExpiredException{
		// TODO Auto-generated method stub
		Users userFind=dao.findById(userName).orElseThrow(() -> new UsernameNotFoundException("Invalid UserId : " + userName));
		userFind.setTime(LocalDateTime.now());
		if(userFind.getOtp()==otp)
		{
			userFind.setOtp(0);
			dao.save(userFind);
		return "OTP Matched";	
		}
		else if(userFind.getOtp()==0)
		{
	        throw new OtpExpiredException("OTP Expired");
		}
		else
		{
			userFind.setOtp(0);
			dao.save(userFind);
			throw new OtpInvalidException("Invalid OTP");
		}
	}
	
}
