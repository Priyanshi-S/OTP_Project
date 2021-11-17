package com.otpproject.config.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class OtpExpiredException extends Exception{
	private static final long serialVersionUID = 1L;
	public OtpExpiredException(String errorMessage)
	{
		super(errorMessage);
	}
}
