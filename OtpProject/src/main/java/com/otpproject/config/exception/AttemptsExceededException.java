package com.otpproject.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class AttemptsExceededException extends Exception{

	public AttemptsExceededException(String errorMessage)
	{
		super(errorMessage);
	}

}
