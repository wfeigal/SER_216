package Core_Week_3;

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
		this.accountType = type;
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
	 * @param accountNumber
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
	 * @param accountHolder
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
	 * @param balance
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
	 * @param accountType
	 */
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	/**
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
