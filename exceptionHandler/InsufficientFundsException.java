package com.exponent.bankapplication.exceptionHandler;

public class InsufficientFundsException extends RuntimeException {
	
	public InsufficientFundsException(String error) {
		super(error);
	}

}
