package trainingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryRepo {
	String driverPackage = "com.mysql.cj.jdbc.Driver"; 
	String dbUrl = "jdbc:mysql://localhost:3306/sakila";
	String userName = "root";
	String password = "aspire@123";
     
	public Connection initializeConnection() {
    	 try {
 			Class.forName(driverPackage);
 			Connection connection = DriverManager.getConnection(dbUrl, userName, password);
 			return connection;
    	 } catch (Exception e) {
  			System.out.println(e);
  		}
		return null;
 		
     }
	
	public String add(Book bookData) throws SQLException {
		Connection con = initializeConnection();
		PreparedStatement dbp = con.prepareStatement("insert into library(id,name,authour) values(?,?,?)");
		dbp.setInt(1, bookData.getBookId());
		dbp.setString(2, bookData.getBookName());
		dbp.setString(3, bookData.getAuthor());
		int success = dbp.executeUpdate();
		con.close();
		if(success!=0) {
			return "SuccessFully Added Data";
		}
		else {
			return "Error";
		}
	}
	
	public List<Book> getAll() throws SQLException{
		ArrayList<Book> booksList = new ArrayList<Book>();
		Connection con = initializeConnection();
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("Select * from library");
		while(result.next()) {
			Book book = new Book();
			book.setBookId(result.getInt(1));
			book.setBookName(result.getString(2));
			book.setAuthor(result.getString(3));
			booksList.add(book);
		}
		return booksList;
	}
	
	public String updateBook(Book oldBookData, Book newBookData) throws SQLException {
		Connection con = initializeConnection();
		if(oldBookData.getBookId() == newBookData.getBookId() && oldBookData.getBookName()!=newBookData.getBookName() && oldBookData.getAuthor()!=newBookData.getAuthor()) {
			PreparedStatement updateStatement = con.prepareStatement("update library set name = ?, authour = ? where id = ?");
			updateStatement.setString(1, newBookData.getBookName());
			updateStatement.setString(2, newBookData.getAuthor());
			updateStatement.setInt(3, oldBookData.getBookId());
			int status = updateStatement.executeUpdate();
			if(status!=0) {
				return "Updated Data";
			}
			else {
				return "Error";
			}
		}
		else if(oldBookData.getBookName() == newBookData.getBookName() && oldBookData.getBookId() != newBookData.getBookId() && oldBookData.getAuthor()!=newBookData.getAuthor()) {}
		else if(oldBookData.getAuthor() == newBookData.getAuthor() && oldBookData.getBookId()!=newBookData.getBookId() && oldBookData.getBookName()!=newBookData.getBookName()) {}
		return "Success";
		
	}
}
