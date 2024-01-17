package controllerTest;

import Controllers.CheckOutController;
import mockFiles.MockBill;
import mockFiles.MockBook;
import mockFiles.MockCategory;
import mockFiles.MockLibrarian;
import models.Bill;
import models.Book;
import models.Category;
import models.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CheckOutControllerTest {


    Category category;
    List<Book> books;
    CheckOutController checkOutController;
    ArrayList<Integer> quantity;
    Person admin;
//    @BeforeAll
//    static void setUp(){
//
//        ArrayList<Book> list = new ArrayList<>();
//        list.add(new Book("1111","Book1",category,"supplier",10,15,15,"a",3,"TestFiles//cost.txt"));
//
//
//    }

    @BeforeEach
    void setUpComponents(){
        admin =new MockLibrarian("Jessy", "Hamburg", "jhamburg21@epoka.edu.al","21/01/2001","jessyhamburg","jessy1234",310,"0697654124");
        category = new MockCategory("Fantasy", "TestFiles//FantasyBooks.dat");
        Book book1 = new MockBook("1111","Book1",category,"supplier",10,15,15,"a",3,"TestFiles//cost.txt");
        Book book2 = new MockBook("2222","Book2",category,"supplier",10,15,15,"a",4,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        books = List.of(book1,book2);
        quantity = new ArrayList<>();
        checkOutController = new CheckOutController(books);
    }

    @AfterEach
    void tearDown()
    {
        category.getBooksOfCategoryBinaryFile().delete();
        File file = new File("TestFiles//cost.txt");
        file.delete();
        file = new File("TestFiles//FantasyBooks.dat");
        file.delete();

    }
    @ParameterizedTest
    @CsvSource({
            "4,2",
            "3, 0",
            "-1, 2"
    })
    void test_validateCheckOutIsInvalid(int value1, int value2){
        quantity.add(value1);
        quantity.add(value2);
        Assertions.assertFalse(checkOutController.validateCheckOut(books, quantity));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3"
    })
    void test_validateCheckOutIsValid(int value1, int value2){
        quantity.add(value1);
        quantity.add(value2);
        Assertions.assertTrue(checkOutController.validateCheckOut(books, quantity));
    }

    @Test
    void test_librarianCheckOut(){
        quantity.add(2);
        quantity.add(3);
        Bill bill = new MockBill(10);
        Assertions.assertEquals(admin,checkOutController.librarianCheckOut(admin,bill,quantity));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 3"
    })
    void test_decreaseStockOfItems(int value1, int value2){
        quantity.add(value1);
        quantity.add(value2);
        Assertions.assertEquals(category.getBooksOfCategory(),checkOutController.decreaseStockOfItems(quantity));
    }
}
