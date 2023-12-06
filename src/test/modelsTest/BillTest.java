package modelsTest;

import javafx.collections.ObservableList;
import mock.MockPrintWriterTry;
import models.Bill;
import models.Book;
import models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

class BillTest {

    Bill bill;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        Book book = new Book("i","t",new Category("C"),"s",10,15,15,"a",1);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        ArrayList<Integer> quantities = new ArrayList<>(1);
        PrintWriter writer = new MockPrintWriterTry(new File("file"));
        bill = new Bill((ObservableList<Book>) books,quantities,writer);
    }

    @Test
    void test_writeToFile()
    {
        bill.writeToFile();
    }

}