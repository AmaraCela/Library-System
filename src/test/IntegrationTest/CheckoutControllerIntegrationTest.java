package IntegrationTest;

import Controllers.CheckOutController;
import Controllers.RegisterStaffController;
import models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CheckoutControllerIntegrationTest {


    static Category category;
    static List<Book> books;
    static CheckOutController checkOutController;
    ArrayList<Integer> quantity;
    static Person librarian;

    @BeforeAll
    static void setUp(){
       RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
       RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));
       librarian =new Librarian("Jessy", "Hamburg", "jhamburg21@epoka.edu.al","21/01/2001","jessyhamburg","jessy1234",310,"0697654124");
    }

    @BeforeEach
    void setUpComponents(){
        category = new Category("Fantasy", "TestFiles//FantasyBooks.dat");
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",3,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",4,"TestFiles//cost.txt");
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
        File file1 = new File("TestFiles//bill.txt");
        file1.delete();
        File file2 = new File("TestFiles//revenues.txt");
        file2.delete();
        File file3 = new File("TestFiles//cost.txt");
        file3.delete();
        file3 = new File("TestFiles//usernames.txt");
        file3.delete();
        file3 = new File("TestFiles//employees.txt");
        file3.delete();

        RegisterStaffController.readFromFile();
    }

    @AfterAll
    static void returnOriginalFiles()
    {
        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        RegisterStaffController.readFromFile();
    }
    @Test
    void test_librarianCheckOut(){
        quantity.add(2);
        quantity.add(3);
        Bill bill = new Bill(books,quantity,"TestFiles//bill.txt","TestFiles//revenues.txt");
        Assertions.assertEquals(5,((Librarian)checkOutController.librarianCheckOut(librarian,bill,quantity)).getNumOfBooksSold());
        Assertions.assertEquals(2,((Librarian)checkOutController.librarianCheckOut(librarian,bill,quantity)).getNumberOfBills());
        Assertions.assertEquals(450,((Librarian)checkOutController.librarianCheckOut(librarian,bill,quantity)).getPersonalRevenue(),0.1);

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
