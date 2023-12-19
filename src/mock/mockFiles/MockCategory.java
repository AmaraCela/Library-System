package mockFiles;

import models.Book;
import models.Category;

import java.util.ArrayList;

public class MockCategory extends Category {

    public ArrayList<Book> books = new ArrayList<>();
    public MockCategory(String categoryName, String booksOfCategoryBinaryFileName) {
        super(categoryName,booksOfCategoryBinaryFileName);
    }

    @Override
    public void addBookToCategory(Book book) {
        books.add(book);
    }
}
