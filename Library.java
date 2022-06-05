package trainingProject;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

	public void welcome() throws SQLException {
		Scanner input = new Scanner(System.in);
		int choice = 0, id, newId;
		String name, authour;
		String newName, newAuthour;

		LibraryServiceImpl libraryOffice = new LibraryServiceImpl();
		do {
			System.out.println("\n__________Welcome To Library________\n1.Add Book\n2.View Book\n3.Update Book\n");
			try {
				choice = input.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("***Please Enter Only Number***");
			}
			
			switch (choice) {
			case 1:
				System.out.println("Enter the Book Id: ");
				id = input.nextInt();
				System.out.println("Enter the Book Name: ");
				name = input.next();
				System.out.println("Enter the Author Name: ");
				authour = input.next();

				Book newBook = new Book();
				newBook.setBookId(id);
				newBook.setBookName(name);
				newBook.setAuthor(authour);

				
				System.out.println(libraryOffice.add(newBook));
				break;

			case 2:
				libraryOffice.getAll().forEach(book -> System.out.println(book.toString()));
				break;

			case 3:
				System.out.println("\tEnter the Existing Book Details");
				System.out.println("Enter the Book Id: ");
				id = input.nextInt();
				System.out.println("Enter the Book Name: ");
				name = input.next();
				System.out.println("Enter the Author Name: ");
				authour = input.next();

				System.out.println("\tEnter the Updating Details");
				System.out.println("Enter the Book Id: ");
				newId = input.nextInt();
				System.out.println("Enter the Book Name: ");
				newName = input.next();
				System.out.println("Enter the Author Name: ");
				newAuthour = input.next();

				Book oldBookData = new Book();
				oldBookData.setBookId(id);
				oldBookData.setBookName(name);
				oldBookData.setAuthor(authour);

				Book newBookData = new Book();
				newBookData.setBookId(newId);
				newBookData.setBookName(newName);
				newBookData.setAuthor(newAuthour);

				System.out.println(libraryOffice.update(oldBookData, newBookData));
				break;

			default:
				System.out.println("----You have entered the Wrong option----\n");
				System.out.println("*Please enter the Correct option from Menu*\n____________________________");
				break;
			}

		} while (choice > 0);
	}

	

}
