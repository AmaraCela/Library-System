package IntegrationTest;

import Controllers.CategoryController;
import Controllers.SupplyBooksController;
import models.Book;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class SupplyBooksControllerIntegrationTest {
    CategoryController category;
    SupplyBooksController supplyBooksController;
    Category category1;
    Category category2;
    Book book1;
    Book book2;

    @BeforeEach
    void setUpComponents() {
        supplyBooksController = new SupplyBooksController();
        category1 = new Category("Fiction", "TestFiles//FictionBooks.dat");
        category2 = new Category("Drama", "TestFiles//DramaBooks.dat");
        book1 = new Book("1111", "Book1", category1, "supplier", 10, 15, 15, "a", 3, "TestFiles//cost.txt");
        book2 = new Book("2222", "Book2", category2, "supplier", 10, 15, 15, "a", 4, "TestFiles//cost.txt");
        category1.addBookToCategory(book1);
        category2.addBookToCategory(book2);
        category = new CategoryController(new File("TestFiles//categoryController.dat"));
        category.addCategories(category1);
        category.addCategories(category2);
    }

    @AfterEach
    void dropDown() {
        category1.getBooksOfCategoryBinaryFile().delete();
        category2.getBooksOfCategoryBinaryFile().delete();
        category.getBinaryFile().delete();
        File file = new File("TestFiles//cost.txt");
        file.delete();
    }
    @Test
    void test_supply(){
        supplyBooksController.addBooks();
        Book book3 = new Book("3333","Book3",category2,"s",100.32,213.3,123.1,"a",1);
        category2.addBookToCategory(book3);
        Assertions.assertEquals(List.of(book1,book2,book3),supplyBooksController.supply("3333","Book3",category2.getCategoryName(),"s",100.32,213.3,123.1,"a",1));
    }
}
