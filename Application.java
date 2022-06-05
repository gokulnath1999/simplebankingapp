package bankingApplication;

import java.sql.SQLException;

public class Application {
	public static void main(String[] args) throws SQLException {
		BankingApp bank = new BankingApp();
		bank.allServices();
	}

}
