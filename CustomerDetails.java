package bankingApplication;

public class CustomerDetails {
	private int accountNumber;
	@Override
	public String toString() {
		return "CustomerDetails [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private String name;
	private double balance;
}
