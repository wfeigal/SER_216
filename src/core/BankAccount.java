package core;

public class BankAccount {

	private String accountNumber = "";
	private String accountHolder = "";
	private double balance = 0;
	private int accountType = 0;
	
	/**
	 * Default constructor
	 */
	public BankAccount(){
		this.balance = 0;
		this.accountType = 0;
		this.accountNumber = "none";
		this.accountHolder = "Unknown";
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param bal Initial balance
	 * @param type Account type 
	 * @param num Account number
	 * @param name Name of account holder
	 */
	public BankAccount(double bal, int type, String num, String name){
		this.balance = bal;
		if (type <= 4 && type >= 0) {
			this.accountType = type;
		}
		else
			this.accountType = 0;
		this.accountNumber = num;
		this.accountHolder = name;
	}
	/**
	 * 
	 * @return Account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * 
	 * @param accountNumber String value representing account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * 
	 * @return Account holder name
	 */
	public String getAccountHolder() {
		return accountHolder;
	}
	/**
	 * 
	 * @param accountHolder Name of the account holder String value
	 */
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	/**
	 * 
	 * @return Current balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * 
	 * @param balance Current balance of the account
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 
	 * @return Account type
	 */
	public int getAccountType() {
		return accountType;
	}
	/**
	 * 
	 * @param accountType Type of account 
	 */
	public void setAccountType(int accountType) {
		if (accountType <= 4 && accountType >= 0) {
			this.accountType = accountType;
		}
		else
			this.accountType = 0;
	}
	/**
	 * Calculates the current balance of the account after applying interest
	 * 
	 * @return the new balance of the account after interest has been applied
	 */
	public double calculateTotalBalance() {    
		double rate = this.getInterestRate();
		if (rate == 0 )
			return 0;
		return this.balance + (balance * rate/100);
	}
	/**
	 * Returns the value representing the percent interest rate for the given account type
	 * 
	 * @return the interest rate of the account depending on its type
	 */
	public double getInterestRate() {
		double intRate = 0;
		
		switch (accountType){
			case 1: intRate = 0.5;
				break;
			case 2: intRate = 4.5;
				break;
			case 3: intRate = 1;
				break;
			case 4: intRate = 15;
				break;
			default: return 0;
		}
		return intRate;
	}
}
