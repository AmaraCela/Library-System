package modelsTest;

import models.Bill;
import models.Book;
import models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    Bill bill;

    @BeforeEach
    void setUp() {
        Book book = new Book("i","t",new Category("C","TestFiles//fictionBooks.dat"),"s",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        ArrayList<Integer> quantities = new ArrayList<>();
        quantities.add(1);
        bill = new Bill(books,quantities,"TestFiles//bill.txt","TestFiles//revenues.txt");


    }

    @Test
    void test_calculateTotal()
    {
        assertEquals(15.0,bill.CalculateTotal(),0.1);

    }

    @Test
    void test_getTotal()
    {
        assertEquals(15.0,bill.getTotal(),0.1);
    }



    @Test
    void test_writeRevenueToFile()
    {
        bill.writeRevenueToFile();
        assertEquals(15.0,Bill.readRevenues("TestFiles//revenues.txt"),0.1);
    }

    @Test
    void test_getRevenues()
    {
        assertEquals(0,Bill.getRevenues("TestFiles//revenues.txt"),0.1);
        bill.CalculateTotal();
        assertEquals(15.0,Bill.readRevenues("TestFiles//revenues.txt"),0.1);

    }

}