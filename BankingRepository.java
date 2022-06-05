package bankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankingRepository {
	
	String driverClass = "com.mysql.cj.jdbc.Driver", dbURL = "jdbc:mysql://localhost:3306/gokul", userName = "root", password = "Aspire@123";
	
	public Connection startConnection() {
		try {
			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(dbURL,userName,password);
			return connection;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Boolean createAccount(CustomerDetails customerInformation) throws SQLException {
		Connection con = startConnection();
		PreparedStatement createStatement = con.prepareStatement("insert into customer (name, balance) values (? ,?)");
		createStatement.setString(1, customerInformation.getName());
		createStatement.setDouble(2, customerInformation.getBalance());
		int condition = createStatement.executeUpdate();
		if(condition != 0)
			return true;
		else
			return false;
		
	}
	
	public List<CustomerDetails> getAllAccounts() throws SQLException {
		Connection con = startConnection();
		ArrayList<CustomerDetails> customerList = new ArrayList<CustomerDetails>();
		Statement query = con.createStatement();
		ResultSet queryResult = query.executeQuery("select * from customer");
		while(queryResult.next()) {
			CustomerDetails customer = new CustomerDetails();
			customer.setAccountNumber(queryResult.getInt(1));
			customer.setName(queryResult.getString(2));
			customer.setBalance(queryResult.getDouble(3));
			customerList.add(customer);
		}
		return customerList;
	}
	
	public CustomerDetails getAccountInformation(int accountNumber) throws SQLException{
		Connection connection = startConnection();
		Statement stmt = connection.createStatement();
		CustomerDetails customerDetails = new CustomerDetails();
		ResultSet queryResult = stmt.executeQuery("select * from customer where accountnumber ="+accountNumber);
		while(queryResult.next()) {
			customerDetails.setAccountNumber(queryResult.getInt(1));
			customerDetails.setName(queryResult.getString(2));
			customerDetails.setBalance(queryResult.getDouble(3));
		}
		return customerDetails;
		
	}
	
	public Boolean deposit(int accountNumber, double amount) throws SQLException {
		double availableAmount = 0;
		Connection con = startConnection();
		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery("select * from customer where accountnumber = "+accountNumber);
		while(resultSet.next()) {
			availableAmount  = resultSet.getDouble(3);
		}
		PreparedStatement depositQuery = con.prepareStatement("update customer set balance = ? where accountnumber = ?");
		depositQuery.setDouble(1, (availableAmount+amount));
		depositQuery.setInt(2, accountNumber);
		int deposited = depositQuery.executeUpdate();
		if(deposited!=0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Boolean withdraw(int accountNumber, double amount) throws SQLException {
		double availableAmount = 0;
		Connection con = startConnection();
		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery("select * from customer where accountnumber = "+accountNumber);
		while(resultSet.next()) {
			availableAmount  = resultSet.getDouble(3);
		}
		if(amount<=availableAmount) {
			PreparedStatement depositQuery = con.prepareStatement("update customer set balance = ? where accountnumber = ?");
			depositQuery.setDouble(1, (availableAmount-amount));
			depositQuery.setInt(2, accountNumber);
			int deposited = depositQuery.executeUpdate();
			if(deposited!=0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	public Boolean deleteAccount(int id) throws SQLException{
		Connection connection = startConnection();
		PreparedStatement deleteStatement = connection.prepareStatement("delete from customer where accountnumber = ?");
		deleteStatement.setInt(1, id);
		int condition = deleteStatement.executeUpdate();
		if(condition != 0)
			return true;
		else
			return false;
	}

	
}
