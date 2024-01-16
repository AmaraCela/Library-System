package IntegrationTest;

import Controllers.AddToStockController;
import Controllers.CategoryController;
import models.Book;
import models.Category;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToStockControllerIntegrationTest {
    AddToStockController addToStockController;
    static Category category;
    static List<Book> books;
    @BeforeAll
    static void setUp(){
        category = new Category("Fiction", "TestFiles//DramaBooks.dat");
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",2,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        books = List.of(book1,book2);
    }

    @BeforeEach
    void setUpController(){
        addToStockController = new AddToStockController();
    }

    @AfterAll
    static void dropDown(){
        File file = new File("TestFiles//DramaBooks.dat");
        file.delete();
        file = new File("cost.txt");
        file.delete();
    }

    @AfterEach
    void drop(){
        File file = new File("TestFiles//fiction.dat");
        file.delete();
        File file1 = new File("TestFiles//cost.txt");
        file1.delete();
    }
    @Test
    void test_returnBookToDisplay(){

        CategoryController categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertEquals(books, addToStockController.addToBookList());
    }

    @Test
    void test_validateStock(){
        addToStockController.validateStock(books, 1);
        assertEquals(books.get(0).getCategory().getBookOfCategory("1111").getStock(),3);
    }
}
