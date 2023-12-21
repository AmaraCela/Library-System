package controllerTest;

import Controllers.AddToStockController;
import Controllers.CategoryController;
import mockFiles.MockBook;
import mockFiles.MockCategory;
import models.Book;
import models.Category;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.List;

public class AddToStockTest {

    AddToStockController addToStockController;
    static Category category;
    static List<Book> books;
    @BeforeAll

    static void setUp(){
        category = new MockCategory("Fiction", "TestFiles//DramaBooks.dat");
        Book book1 = new MockBook("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new MockBook("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        books = List.of(book1,book2);
    }
    @BeforeEach
    void setUpController(){
        addToStockController = new AddToStockController();
    }
    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//cost.txt");
        file.delete();
    }

    @Test
    void test_returnBookToDisplay(){

        CategoryController categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        Assertions.assertEquals(books, addToStockController.addToBookList());
    }

    @ParameterizedTest
    @CsvSource({
            "2",
            "4"
    })
    void test_validateValidStock(int stock){
        Assertions.assertTrue(addToStockController.validateStock(books, stock));
    }
    @ParameterizedTest
    @CsvSource({
            "0",
            "-2"
    })
    void test_validateInvalidStock(int stock){
        Assertions.assertFalse(addToStockController.validateStock(books, stock));
    }

}
