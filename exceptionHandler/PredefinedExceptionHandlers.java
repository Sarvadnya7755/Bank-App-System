package com.exponent.bankapplication.exceptionHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PredefinedExceptionHandlers {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int getVerifiedUserChoice() {
		
		int op = 0;
		
		try {
			op = sc.nextInt();
	        sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.print("-->[ERROR] Invalid input. "
					+ "\n--> Please Enter a Valid Numeric Option :- ");
			sc.nextLine();
			return getVerifiedUserChoice();
		}
		return op;
	}
	
}
