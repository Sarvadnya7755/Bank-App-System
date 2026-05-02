package com.exponent.bankapplication.serviceImpl;

import java.util.Scanner;

import com.exponent.bankapplication.Validation.Validation;
import com.exponent.bankapplication.accountnogenerationvalidation.Account_No_Generator;
import com.exponent.bankapplication.exceptionHandler.AccountDoesNotExistException;
import com.exponent.bankapplication.exceptionHandler.InsufficientFundsException;
import com.exponent.bankapplication.exceptionHandler.PredefinedExceptionHandlers;
import com.exponent.bankapplication.model.Account;
import com.exponent.bankapplication.model.MaxAccount;
import com.exponent.bankapplication.service.RBI;

public class STATE_BANK_OF_INDIA implements RBI {

	Account[] accarr = new Account[MaxAccount.MAX_ACCOUNT];
	static Scanner sc = new Scanner(System.in);

	@Override
	public void openAccount() {
		boolean flag = true;
		do {
			System.out.print("--> Enter the total number of accounts to be created :- ");
			int n = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			if (n <= MaxAccount.MAX_ACCOUNT) {
				for (int i = 0, j = 1; i < n; ++i, ++j) {
					Account ac = new Account();
					System.out.println("|>-------------------------<|");
					System.out.println("|> Enter Account " + j + " Details <|");
					System.out.println("|>-------------------------<|");
					System.out.println("");
					long mob = Validation.validateMobileNo();
					ac.setMobileNo(mob);
					ac.setAccountNo(Account_No_Generator.generateAccountNo());
					System.out.println("--> Generated Account No.       :- " + ac.getAccountNo());
					String mail = Validation.validateEmailID();
					ac.setAddress(mail);
					String password = Validation.validatePassword();
					ac.setPassword(password);
					String name = Validation.validateName();
					ac.setAccountHolderName(name);
					String aadhar = Validation.validateAadharCard();
					ac.setAadharCardNo(aadhar);
					String panno = Validation.validatePanCard();
					ac.setPanCardNo(panno);
					System.out.print("--> Enter Account Balance       :- Rs.");
					double salary = sc.nextLong();
					ac.setAccountBalance(salary);
					sc.nextLine();
					accarr[i] = ac;
					System.out.println("");
				}
				System.out.print("--> Confirm Account Creation (true/false) :- ");
				Boolean confirm = sc.nextBoolean();
				sc.nextLine();
				if (confirm == true) {
					System.out.println("");
					System.out.println("|>---------------------------------------------------<|");
					System.out.println("|>>>  All accounts have been successfully created  <<<|");
					System.out.println("|>---------------------------------------------------<|");
					System.out.println("");
					flag = false;
					break;
				} else {
					openAccount();
					break;
				}
			} else {
				System.out.println("|>------------------------------------------------------------------<|");
				System.out.println("|> Account limit exceeded. Maximum number of accounts allowed is "
						+ MaxAccount.MAX_ACCOUNT + ". <|");
				System.out.println("|>------------------------------------------------------------------<|");
				System.out.println("");
			}
		} while (flag);
	}

	@Override
	public void getAccountDetails() {
		System.out.println("--> Fetching Account Details . . .");
		System.out.println("");
		for (Account ac : accarr) {
			if (ac != null) {
				System.out.println(ac);
				System.out.println("");
			}
		}
	}

	@Override
	public void getAccountBalance() {
		long acc = Validation.validateAccountNumber();
		String password = Validation.validatePassword();
		boolean found = false;
		for (Account ac : accarr) {
			if (ac != null && acc == ac.getAccountNo() && ac.getPassword().equals(password)) {
				System.out.println("---------------------------------------------------");
				System.out.println("");
				System.out.println("Account No.         :- " + ac.getAccountNo());
				System.out.println("Account Holder Name :- " + ac.getAccountHolderName());
				System.out.println("Account Balance     :- Rs." + ac.getAccountBalance() + " /-");
				System.out.println("");
				System.out.println("---------------------------------------------------");
				System.out.println("");
				found = true;
			}
		}
		if(!found) {
			System.out.println("");
			throw new AccountDoesNotExistException("Account not found.");
		}
	}

	@Override
	public void withdrawFunds() {
		long acc = Validation.validateAccountNumber();
		String password = Validation.validatePassword();
		boolean found = false;
		boolean amountWithdrawn = false;
		for (Account ac : accarr) {
			if (ac != null && acc == ac.getAccountNo() && ac.getPassword().equals(password)) {
				System.out.println("---------------------------------------------------");
				System.out.println("");
				System.out.print("--> Enter The Amount to Withdraw  :- Rs.");
				double withdraw = sc.nextDouble();
				sc.nextLine();
				if (ac.getAccountBalance() >= withdraw) {
					ac.setAccountBalance(ac.getAccountBalance() - withdraw);
					System.out.println("");
					System.out.println("--> [SUCCESS] Transaction successful. Rs." + withdraw
							+ " /- has been withdrawn from your account.");
					System.out.println("");
					amountWithdrawn = true;
					found = true;
				} 
			}
			if (!found) {
				System.out.println("");
				throw new AccountDoesNotExistException("Account not found. Please verify the account details.");
			}
			if(!amountWithdrawn) {
				System.out.println("");
				throw new InsufficientFundsException("Transaction Failed Due To Insufficient Balance");
			}
		}
	}

	@Override
	public void depositFunds() {
		long acc = Validation.validateAccountNumber();
		String password = Validation.validatePassword();
		boolean found = false;
		for (Account ac : accarr) {
			if (ac != null && acc == ac.getAccountNo() && ac.getPassword().equals(password)) {
				System.out.println("---------------------------------------------------");
				System.out.println("");
				System.out.print("--> Enter The Amount to Deposit  :- Rs.");
				double deposit = sc.nextDouble();
//				sc.next();
				ac.setAccountBalance(ac.getAccountBalance() + deposit);
				System.out.println("");
				System.out.println("--> [SUCCESS] Transaction completed. Rs." + deposit
						+ " /- has been credited to your account.");
				System.out.println("");
				found = true;
			}else {
				System.out.println("");
				throw new AccountDoesNotExistException("Account not found. Please verify the account details.");
			}
		}
	}

	@Override
	public void updateAccountDetails() {
		long acc = Validation.validateAccountNumber();
		String password = Validation.validatePassword();
		System.out.println("");

		Account accnt = null;

		for (Account ac : accarr) {
			if (ac != null && acc == ac.getAccountNo() && ac.getPassword().equals(password)) {
				accnt = ac;
			}
		}
		if (accnt == null) {
			System.out.println("");
			System.out.println("--> [ERROR] Account not found. Please verify the account details.");
			System.out.println("");
			return;
		}

		boolean flag = true;
		do {
			System.out.println("");
			updateMenu();
			System.out.println("");
			int opt = PredefinedExceptionHandlers.getVerifiedUserChoice();
			System.out.println("");
			switch (opt) {
			case 1:
				updateName(accnt);
				break;
			case 2:
				updateMailID(accnt);
				break;
			case 3:
				updateMobileNo(accnt);
				break;
			case 4:
				System.out.print("--> Confirm update (true/false): ");
				boolean confirm = sc.nextBoolean();
				sc.nextLine();
				System.out.println("");
				if (confirm) {
					System.out.println("--> [SUCCESS] Account information updated successfully.");
					System.out.println("");
					flag = false;
				} else {
					System.out.println("--> [INFO] Update operation cancelled.");
					System.out.println("");
				}
				break;
			default:
				System.out.println("--> [ERROR] Invalid Option Selected.");
				break;
			}
		} while (flag);
	}

	private static void updateMobileNo(Account ac) {
		long mob = Validation.validateMobileNo();
		ac.setMobileNo(mob);
		System.out.println("");
		System.out.println("--> [SUCCESS] Mobile number updated successfully.");
	}

	private static void updateMailID(Account ac) {
		String mail = Validation.validateEmailID();
		ac.setEmailID(mail);
		System.out.println("");
		System.out.println("--> [SUCCESS] Email address updated successfully.");
	}

	private static void updateName(Account ac) {
		String name = Validation.validateName();
		ac.setAccountHolderName(name);
		System.out.println("");
		System.out.println("--> [SUCCESS] Account holder name updated successfully.");
	}

	private void updateMenu() {
		System.out.println("|>------------------------<|");
		System.out.println("|>>>   UPDATE ACCOUNT   <<<|");
		System.out.println("|>------------------------<|");
		System.out.println("| 1. Update Name.          |");
		System.out.println("| 2. Update Email Address  |");
		System.out.println("| 3. Update Contact No.    |");
		System.out.println("| 4. Confirm Updation      |");
		System.out.println("|--------------------------|");
	}

	public void closeScanner() {
		sc.close();
	}
}
