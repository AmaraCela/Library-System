package controllerTest;

import Controllers.AddToStockController;
import Views.AddToStockView;
import javafx.collections.ObservableList;
import models.Administrator;
import models.Book;
import models.Category;
import models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddToStockTest {

    static Person person;
    static AddToStockView addToStockView;
    AddToStockController addToStockController;
    static Category category;
    @BeforeAll
    static void setUp(){
        person = new Administrator("ADMIN","admini", "adm@gmail.com","12/01/2002","adm","adm123",1245.1,"pno");
        addToStockView = new AddToStockView(addToStockView.getStage());
        category = new Category("Fiction", "TestFiles//fictionBooks.dat");

    }
    @BeforeEach
    void setUpController(){
        addToStockController = new AddToStockController(person, addToStockView);
    }
    @Test
    void test_returnBookToDisplay(){
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        List<Book> books = List.of(book1,book2);
        Assertions.assertEquals(books, addToStockController.returnBookToDisplay((ObservableList<Book>) books));
    }
}
