package bankingApplication;

import java.sql.SQLException;
import java.util.List;

public class BankingImpl implements BankingService {
	
	BankingRepository repo = new BankingRepository();

	@Override
	public String addAccount(CustomerDetails customerDetails) throws SQLException {
		if(repo.createAccount(customerDetails)) {
			return "Added Data";
		}
		else {
			return "Error";
		}
	}

	@Override
	public void getAllAccounts() throws SQLException {
		List<CustomerDetails> customers = repo.getAllAccounts();
		CustomerDetails customer = new CustomerDetails();
		customers.forEach(customerInformation->{
			System.out.println(customerInformation.toString());
//			if(customerInformation.getAccountNumber() == accountNumber) {
//				System.out.println(customerInformation.toString());
//			}
		});
	}

	@Override
	public String updateBalance(int accountnumber, double amount) throws SQLException {
		if(repo.deposit(accountnumber, amount)) {
			return "Amount Deposited";
		}
		else {
			return "Error";
		}
	}

	@Override
	public String withdrawBalance(int accountnumber, double amount) throws SQLException {
		if(repo.withdraw(accountnumber, amount)) {
			return "Amount Withdrawed";
		}
		else {
			return "Error";
		}
	}

	@Override
	public String getAccountInformation(int id) throws SQLException {
		if(repo.getAccountInformation(id).getAccountNumber()==id) {
			System.out.println(repo.getAccountInformation(id).toString());
		}
		else {
			return "Error";
		}
		return null;	
	}

	@Override
	public String deleteAccount(int id) throws SQLException {
		if(repo.deleteAccount(id)) {
			return "Deleted Account Successfully";
		}
		else {
			return "Error";
		}
	}

}
