package com.otpproject.config.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private String userName;
	private String emailId;
	private String state;
	private int otp;
	private int attempts;
	private LocalDateTime time;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String emailId, String state, int otp, int attempts, LocalDateTime time) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.state = state;
		this.otp = otp;
		this.attempts= attempts;
		this.time= time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", emailId=" + emailId + ", state=" + state + ", otp=" + otp
				+ ", attempts=" + attempts + ", time=" + time + "]";
	}
	
	

}
