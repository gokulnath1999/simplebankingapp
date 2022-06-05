package trainingProject;

import java.sql.SQLException;
import java.util.List;

public interface LibraryService {

	String add(Book bookData) throws SQLException;

	List<Book> getAll() throws SQLException;

	String update(Book oldBookData, Book updateData);
}
