package bankingApplication;

import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
	int choice = 0, accountNumber;
	String name;
	Double initialAmount, amount;
	Scanner input = new Scanner(System.in);
	
	BankingImpl bankImpl = new BankingImpl();
	public void allServices() throws SQLException {
		do {
			System.out.println("_______________________\n\tWelcome to Bank\n1.User\n2.Manager\n\nEnter your option: ");
			choice = input.nextInt();
			switch(choice) {
			
			case 1:
				user();
				break;
				
			case 2:
				manager();
				break;
				
			default:
				System.out.println("Please Enter the Option from Above");
				break;
				
			}
		}while(choice>0);
		
	}
	
	public void manager() throws SQLException {
		int managerChoice =0;
		System.out.println("_______________________\n1.Create Account\n2.Deposit Amount\n3.Get All Accounts\n4.Get Account Information\n5.Delete Account\nEnter your option:");
		managerChoice = input.nextInt();
		switch(managerChoice) {
		case 1:
			System.out.println("Enter User Name :");
			name = input.next();
			System.out.println("Initial Amount to Deposit :");
			initialAmount = input.nextDouble();
			
			CustomerDetails customer = new CustomerDetails();
			customer.setName(name);
			customer.setBalance(initialAmount);
			System.out.println(bankImpl.addAccount(customer));
			break;
			
		case 2:
			System.out.println("Enter Account Number:");
			accountNumber= input.nextInt();
			System.out.println("Enter Amount:");
			amount = input.nextDouble();
			System.out.println(bankImpl.updateBalance(accountNumber, amount));
			break;
			
		case 3:
			bankImpl.getAllAccounts();
			break;
			
		case 4:
			System.out.println("Enter the Account Number:");
			accountNumber = input.nextInt();
			bankImpl.getAccountInformation(accountNumber);
			break;
			
		case 5:
			System.out.println("Enter the Account Number:");
			accountNumber = input.nextInt();
			System.out.println(bankImpl.deleteAccount(accountNumber));
			break;
		
		}
	}
	
	public void user() throws SQLException {
		int userChoice = 0;
		System.out.println("_______________________\n1.Deposit Amount\n2.Withdraw Amount\n3.Get Account Information\n\nEnter your option:");
		userChoice = input.nextInt();
		switch(userChoice) {
		case 1:
			System.out.println("Enter Account Number:");
			accountNumber= input.nextInt();
			System.out.println("Enter Amount:");
			amount = input.nextDouble();
			System.out.println(bankImpl.updateBalance(accountNumber, amount));
			break;
			
		case 2:
			System.out.println("Enter Account Number:");
			accountNumber= input.nextInt();
			System.out.println("Enter Amount:");
			amount = input.nextDouble();
			System.out.println(bankImpl.withdrawBalance(accountNumber, amount));
			break;
	
		case 3:
			System.out.println("Enter the Account Number:");
			accountNumber = input.nextInt();
			bankImpl.getAccountInformation(accountNumber);
			break;
		}
	}

}
