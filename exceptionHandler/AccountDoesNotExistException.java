package com.exponent.bankapplication.exceptionHandler;

public class AccountDoesNotExistException extends RuntimeException {
	
	public AccountDoesNotExistException(String error) {
		super(error);
	}

}
