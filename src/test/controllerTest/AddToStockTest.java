package controllerTest;

import Controllers.AddToStockController;
import Controllers.CategoryController;
import models.Book;
import models.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.List;

public class AddToStockTest {

//    static Person person;
//    static BorderPane addToStockView;
    AddToStockController addToStockController;
    static Category category;
    static List<Book> books;
    @BeforeAll
    static void setUp(){
//        person = new Administrator("ADMIN","admini", "adm@gmail.com","12/01/2002","adm","adm123",1245.1,"pno");
//        addToStockView = new AddToStockView(new MockStage());
        category = new Category("Fiction", "TestFiles//DramaBooks.dat");
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        books = List.of(book1,book2);
    }
    @BeforeEach
    void setUpController(){
        addToStockController = new AddToStockController();
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
