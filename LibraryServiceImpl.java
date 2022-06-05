package trainingProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
	
	LibraryRepo repository = new LibraryRepo();

	ArrayList<Book> books = new ArrayList<Book>();
	int bookIndex = 0;
	boolean update = false;

	@Override
	public String add(Book bookData) throws SQLException {
		//books.add(bookData);
		return repository.add(bookData);
	}

	@Override
	public List<Book> getAll() throws SQLException {
		return repository.getAll();
	}

	@Override
	public String update(Book oldBookData, Book updatedData) {
		books.forEach(book -> {
			if (oldBookData.getBookId() == book.getBookId() && oldBookData.getBookName() == book.getBookName()
					&& oldBookData.getAuthor() == book.getAuthor()) {
				books.set(bookIndex, updatedData);
				bookIndex = 0;
				update = true;
			}
			bookIndex = bookIndex + 1;
		});
		if (update) {
			return "Updated Book Information";
		} else {
			return "Not Able to Update the Information";
		}
	}

}
