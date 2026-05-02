package com.exponent.bankapplication.controller;

import java.util.Scanner;

import com.exponent.bankapplication.exceptionHandler.AccountDoesNotExistException;
import com.exponent.bankapplication.exceptionHandler.InsufficientFundsException;
import com.exponent.bankapplication.exceptionHandler.PredefinedExceptionHandlers;
import com.exponent.bankapplication.serviceImpl.STATE_BANK_OF_INDIA;

public class STATE_BANK_OF_INDIA_Bank_Controller {
	
	public static void main(String[] args) {
		
		STATE_BANK_OF_INDIA sbi = new STATE_BANK_OF_INDIA();
		Scanner sc = new Scanner(System.in);
		displayTitle();
		runBankSystem(sbi, sc);	
		sbi.closeScanner();
	}

	private static void runBankSystem(STATE_BANK_OF_INDIA sbi, Scanner sc) {
		boolean flag = true;
		boolean accountCreated = false;
		do {
			displayMenu();
			System.out.print("--> Enter Your Preferred Option :- ");
			int opt = PredefinedExceptionHandlers.getVerifiedUserChoice();
			System.out.println("");
//			sc.nextLine();
			if(opt == 1) {
				sbi.openAccount();
				accountCreated = true;
			}
			
			switch (opt) {
			case 1 :
				
				break;
			case 2 :
				if(!accountCreated) {
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("|>>>  No Account Found. Please Create an Account First. <<<|");
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("");
			        break;
				}
				sbi.getAccountDetails();
				break;
			case 3 : 
				if(!accountCreated) {
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("|>>>  No Account Found. Please Create an Account First. <<<|");
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("");
			        break;
				}
				try {
					sbi.getAccountBalance();
				} catch (AccountDoesNotExistException e) {
					System.out.println(e);
					System.out.println("");
				}
				break;
			case 4 :
				if(!accountCreated) {
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("|>>>  No Account Found. Please Create an Account First. <<<|");
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("");
			        break;
				}
				try {
					sbi.withdrawFunds();
				} catch (InsufficientFundsException ie) {
					System.out.println(ie);
					System.out.println("");
				} catch (AccountDoesNotExistException ae) {
					System.out.println(ae);
					System.out.println("");
				}
				break;
			case 5 :
				if(!accountCreated) {
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("|>>>  No Account Found. Please Create an Account First. <<<|");
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("");
			        break;
				}
				try {
					sbi.depositFunds();
				} catch (AccountDoesNotExistException ae) {
					System.out.println(ae);
					System.out.println("");
				}
				break;
			case 6 :
				if(!accountCreated) {
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("|>>>  No Account Found. Please Create an Account First. <<<|");
			        System.out.println("|>--------------------------------------------------------<|");
			        System.out.println("");
			        break;
				}
				sbi.updateAccountDetails();
				break;
			case 7 :
				System.out.print("--> Exit The Application (true/false) :- ");
				boolean exit = sc.nextBoolean();
				sc.nextLine();
				System.out.println("");
				if(exit == true) {
					System.out.println("|>------------------------------------------------<|");
					System.out.println("|>>>    Application terminated successfully     <<<|");
					System.out.println("|>>>    Thank you for using Bank of America.    <<<|");
					System.out.println("|>------------------------------------------------<|");
					System.out.println("");
					flag = false;
					break;
				}else {
					System.out.println("--> Exit operation cancelled. Redirecting to the main menu...");
					System.out.println("");
					break;
				}
			default :
				System.out.println("|>-----------------------------<|");
				System.out.println("|> INVALID INPUT, TRY AGAIN !! <|");
				System.out.println("|>-----------------------------<|");
				System.out.println("");
			}
		}while(flag);
	}
	
	private static void displayTitle() {
		System.out.println("|>---------------------------------------------<|");
		System.out.println("||>>>    Welcome To State Bank Of India      <<<|");
		System.out.println("|>---------------------------------------------<|");
		System.out.println("");
	}
	
	private static void displayMenu() {
		System.out.println("|>---------------------------------------------<|"
			           + "\n| >>>>>>>   ACCOUNT MANAGEMENT MENU    <<<<<<<< |"
			           + "\n|>---------------------------------------------<|"
			           + "\n|> 1. Create Account.                          <|"
			           + "\n|> 2. Show Account Details.                    <|"
			           + "\n|> 3. Show Account Balance.                    <|"
			           + "\n|> 4. Withdraw Money.                          <|"
			           + "\n|> 5. Deposit Money.                           <|"
			           + "\n|> 6. Update Account Details.                  <|"
			           + "\n|> 7. Exit Application.                        <|"
			           + "\n|>---------------------------------------------<|");
		System.out.println("");
	}
}
