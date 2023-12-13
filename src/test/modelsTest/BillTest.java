package modelsTest;

import models.Bill;
import models.Book;
import models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class BillTest {

    Bill bill;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        Book book = new Book("i","t",new Category("C","TestFiles//fictionBooks.dat"),"s",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        ArrayList<Integer> quantities = new ArrayList<>(1);


    }

    @Test
    void test_writeRevenueToFile()
    {

    }

}