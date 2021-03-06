package com.otpproject.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String errorMessage)
	{
		super(errorMessage);
		System.out.println(errorMessage);
	}

}
