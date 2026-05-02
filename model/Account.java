package com.exponent.bankapplication.model;
//edit code
import com.exponent.bankapplication.accountnogenerationvalidation.Account_No_Generator;

public class Account {
	
	private long mobileNo;
	private String emailID;
	private String password;
	private String accountHolderName;
	private String aadharCardNo;
	private String panCardNo;
	private String address;
	private long accountNo;
	private double accountBalance;
	
	
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAadharCardNo() {
		return aadharCardNo;
	}
	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}
	public String getPanCardNo() {
		return panCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return      "|>---------------------------------------------<|"
				+ "\n| >>>>>>>>>   ACCOUNT HOLDER DETAILS   <<<<<<<< |"
				+ "\n|>---------------------------------------------<|"
				+ "\n| Generated Account No.   :- " + getAccountNo()                                               
				+ "\n| Account Holder Name     :- " + getAccountHolderName()  
				+ "\n| Contact No.             :- " + getMobileNo()
				+ "\n| Email Address           :- " + getEmailID()
				+ "\n| Aadhar Card No.         :- " + getAadharCardNo()              
				+ "\n| Pan Card No.            :- " + getPanCardNo() 
				+ "\n| Address                 :- " + getAddress()
				+ "\n| Current Account Balance :- Rs." + getAccountBalance() + " /-"
				+ "\n|>---------------------------------------------<|";
	}
	
	

}
