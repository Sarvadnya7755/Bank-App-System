package com.exponent.bankapplication.accountnogenerationvalidation;

public class Account_No_Generator {
	
	public static long generateAccountNo() {
		
		long accountNO = (long)(Math.random()*Math.pow(10, 12));
		return accountNO;
	}
}