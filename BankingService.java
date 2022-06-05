package bankingApplication;

import java.sql.SQLException;

public interface BankingService {

	String addAccount(CustomerDetails customerDetails) throws SQLException ;
	
	void getAllAccounts() throws SQLException;
	
	String updateBalance(int id, double amount) throws SQLException ;
	
	String withdrawBalance(int id, double amount) throws SQLException ;
	
	String getAccountInformation(int id) throws SQLException;
	
	String deleteAccount(int id) throws SQLException;

}