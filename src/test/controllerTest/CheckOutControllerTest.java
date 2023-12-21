package controllerTest;

import Controllers.CheckOutController;
import mockFiles.MockBook;
import mockFiles.MockCategory;
import mockFiles.MockLibrarian;
import models.Bill;
import models.Book;
import models.Category;
import models.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class CheckOutControllerTest {


    static Category category;
    static List<Book> books;
    static CheckOutController checkOutController;
    ArrayList<Integer> quantity;
    static Person admin;
    @BeforeAll
    static void setUp(){
        admin =new MockLibrarian("Jessy", "Hamburg", "jhamburg21@epoka.edu.al","21/01/2001","jessyhamburg","jessy1234",310,"0697654124");
        checkOutController = new CheckOutController();

    }

    @BeforeEach
    void setUpComponents(){
        category = new MockCategory("Fantasy", "TestFiles//FantasyBooks.dat");
        Book book1 = new MockBook("1111","Book1",category,"supplier",10,15,15,"a",3,"TestFiles//cost.txt");
        Book book2 = new MockBook("2222","Book2",category,"supplier",10,15,15,"a",4,"TestFiles//cost.txt");
        books = List.of(book1,book2);
        quantity = new ArrayList<>();
    }

    @AfterEach
    void tearDown()
    {
        category.getBooksOfCategoryBinaryFile().delete();
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
        Bill bill = new Bill(books,quantity);
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
        Assertions.assertSame(category.readBooks(),checkOutController.decreaseStockOfItems(quantity, category));
    }
}
