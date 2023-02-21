package javaassignment3;

import java.util.Comparator;
import java.util.TreeSet;

class SavingAccountCompare implements Comparator<SavingAccount> {

	@Override
	public int compare(SavingAccount account1, SavingAccount account2) {

		if (account1.getAcc_ID() > account2.getAcc_ID()) {
			return 1;
		} else {
			return -1;
		}
	}
}

class SavingAccount {

	private double acc_balance;
	private int acc_ID;
	private String accountHolderName;
	private boolean isSalaryAccount;

	public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) {
		super();
		this.acc_balance = acc_balance;
		this.acc_ID = acc_ID;
		this.accountHolderName = accountHolderName;
		this.isSalaryAccount = isSalaryAccount;
	}

	public double getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}

	public int getAcc_ID() {
		return acc_ID;
	}

	public void setAcc_ID(int acc_ID) {
		this.acc_ID = acc_ID;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public boolean isSalaryAccount() {
		return isSalaryAccount;
	}

	public void setSalaryAccount(boolean isSalaryAccount) {
		this.isSalaryAccount = isSalaryAccount;
	}

	public void deposit(double depositAmount) {

		acc_balance += depositAmount;
		System.out.println("\n");
		System.out.println("Deposited " + depositAmount + " on Account ID: " + getAcc_ID());

	}

	public void withdraw(double withdrawAmount) {

		if (withdrawAmount > acc_balance) {
			System.out.println("Insufficient funds to withdraw!");
		} else {
			acc_balance -= withdrawAmount;
			System.out.println("\n");
			System.out.println("Withdrawal of " + withdrawAmount + " is successful on Account ID: " + getAcc_ID());
		}
	}

	@Override
	public String toString() {
		return "SavingAccount -> acc_balance: " + acc_balance + ", acc_ID: " + acc_ID + ", accountHolderName: "
				+ accountHolderName + ", isSalaryAccount: " + isSalaryAccount;
	}

}

class BankAccountList {

	private TreeSet<SavingAccount> savingAccounts = new TreeSet<>(new SavingAccountCompare());

	public boolean addSavingAccount(SavingAccount savingAccount) {

		for (SavingAccount account : savingAccounts) {
			if (savingAccount.getAcc_ID() == account.getAcc_ID()) {
				return false;
			}
		}

		savingAccounts.add(savingAccount);
		return true;
	}

	public void displaySavingAccountIds() {

		for (SavingAccount account : savingAccounts) {
			System.out.println(account);
		}

	}
}

public class Assignment3Q9 {

	public static void main(String[] args) {
		SavingAccount account1 = new SavingAccount(10000, 101, "Aditya Sharma", true);
		SavingAccount account2 = new SavingAccount(15000, 104, "Abhijeet Singh", false);
		SavingAccount account3 = new SavingAccount(24000, 102, "Kartik Dwivedi", true);
		SavingAccount account4 = new SavingAccount(30000, 103, "Tarun Singh", true);

		BankAccountList accountList = new BankAccountList();

		if (accountList.addSavingAccount(account1)) {
			System.out.println("Added Saving account with Account ID: " + account1.getAcc_ID());
		} else {
			System.out.println("This Savings Account is already present");
		}

		if (accountList.addSavingAccount(account2)) {
			System.out.println("Added Saving account with Account ID: " + account2.getAcc_ID());
		} else {
			System.out.println("This Savings Account is already present");
		}

		if (accountList.addSavingAccount(account3)) {
			System.out.println("Added Saving account with Account ID: " + account3.getAcc_ID());
		} else {
			System.out.println("This Savings Account is already present");
		}

		if (accountList.addSavingAccount(account4)) {
			System.out.println("Added Saving account with Account ID: " + account4.getAcc_ID());
		} else {
			System.out.println("This Savings Account is already present");
		}
		System.out.println("\n");

		accountList.displaySavingAccountIds();

		account1.deposit(10000);

		accountList.displaySavingAccountIds();

		account1.withdraw(8000);

		accountList.displaySavingAccountIds();

	}

}
