package mockFiles;

import models.Book;
import models.Category;

public class MockBook extends Book {
    public MockBook(String ISBN, String title, Category category, String supplier, double purchasedPrice, double originalPrice, double sellingPrice, String author, int stock, String costFileName) {
        super(ISBN, title, category, supplier, purchasedPrice, originalPrice, sellingPrice, author, stock, costFileName);
    }
}
