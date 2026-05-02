package com.exponent.bankapplication.Validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

	static Scanner sc = new Scanner(System.in);

	public static long validateMobileNo() {
		System.out.print("--> Enter Mobile No.            :- ");
		long mob = sc.nextLong();
		sc.nextLine();
		String mobstr = String.valueOf(mob);
		if (mobstr.length() == 10 && (mobstr.startsWith("6") || mobstr.startsWith("7") || mobstr.startsWith("8")
				|| mobstr.startsWith("9"))) {
			return mob;
		} else {
			System.out.println("--> [ERROR] Invalid mobile number format. Please enter a valid 10-digit mobile number.");
			return validateMobileNo();
		}
	}

	public static String validateEmailID() {
		System.out.print("--> Enter Email ID              :- ");
		String email = sc.next();
		sc.nextLine();
		if (Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email)) {
			return email;
		} else {
			System.out.println(
					"--> [ERROR] Invalid email address format. Please enter a valid email (e.g., user@example.com).");
			return validateEmailID();
		}
	}

	public static String validatePassword() {
		System.out.print("--> Create Password             :- ");
		String password = sc.next();
		sc.nextLine();

		int MIN = 2;
		int MAX = 8;

		String regex = "^.{" + MIN + "," + MAX + "}$";

		if (Pattern.matches(regex, password)) {
			return password;
		} else {
			System.out.println("--> [ERROR] Password must contain:");
			System.out.println("    - At least 1 uppercase letter");
			System.out.println("    - At least 1 lowercase letter");
			System.out.println("    - At least 1 digit");
			System.out.println("    - At least 1 special character");
			System.out.println("    - Length:");
			System.out.println("        min :- " + MIN);
			System.out.println("        max :- " + MAX);

			return validatePassword(); // retry
		}
	}

	public static String validateName() {
		System.out.print("--> Enter Account Holder Name   :- ");
		String name = sc.next();
		sc.nextLine();
		if (Pattern.matches("[A-Za-z ]+", name)) {
			return name;
		} else {
			System.out.println("--> [ERROR] Invalid name. Please enter a valid name.");
			return validateName();
		}
	}

	public static String validateAadharCard() {
		System.out.print("--> Enter Aadhar Card No.       :- ");
		String aad = sc.nextLine();
		if (aad.length() == 14 && Pattern.matches("[2-9]{1}[0-9]{3}[ ]{1}[0-9]{4}[ ]{1}[0-9]{4}", aad)) {
			return aad;
		} else {
			System.out.println("--> [ERROR] Invalid Aadhaar format. Please enter a valid 12-digit Aadhaar number.");
			return validateAadharCard();
		}
	}

	public static String validatePanCard() {
		System.out.print("--> Enter Pan Card No.          :- ");
		String panno = sc.next();
		sc.nextLine();
		if (Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", panno) && panno.length() == 10) {
			return panno;
		} else {
			System.out.println(
					"--> [ERROR] Invalid PAN format. Please enter a valid 10-character PAN (e.g., ABCDE1234F).");
			return validatePanCard();
		}
	}

	public static long validateAccountNumber() {
		System.out.print("--> Enter Account No.           :- ");
		long acc = sc.nextLong();
		sc.nextLine();

		String ac = String.valueOf(acc);

		String regex = "^[1-9][0-9]{11}$";

		if (Pattern.matches(regex, ac)) {
			return acc;
		} else {
			System.out.println("--> [ERROR] Invalid Account Number!");
			System.out.println("    - Must be exactly 12 digits");
			System.out.println("    - Should not start with 0");
			System.out.println("");
			return validateAccountNumber(); // retry
		}
	}
}
