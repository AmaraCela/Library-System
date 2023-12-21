package modelsTest;

import mockFiles.MockBook;
import mockFiles.MockCategory;
import models.Bill;
import models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    Bill bill;

    @BeforeEach
    void setUp() {
        Book book = new MockBook("i","t",new MockCategory("C","TestFiles//fictionBooks.dat"),"s",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        ArrayList<Integer> quantities = new ArrayList<>();
        quantities.add(1);
        bill = new Bill(books,quantities,"TestFiles//bill.txt","TestFiles//revenues.txt");
    }

    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//revenues.txt");
        file.delete();
        file = new File("TestFiles//bill.txt");
        file.delete();
        file = new File("TestFiles//cost.txt");
        file.delete();
        Bill.readRevenues("TestFiles//revenues.txt");
    }

    @Test
    void test_calculateTotal()
    {
        assertEquals(15.0,bill.CalculateTotal(),0.1);
    }


    @Test
    void test_writeRevenueToFile()
    {
        bill.CalculateTotal();
        bill.writeRevenueToFile();
        assertEquals(15.0,Bill.readRevenues("TestFiles//revenues.txt"),0.1);
    }

    @Test
    void test_writeRevenueToFileNotFound()
    {
        bill = new Bill(null,null,"TestFilesssss//bill.txt","TestFilessss//revenues.txt");
        bill.writeRevenueToFile();
    }

    @Test
    void test_getRevenues()
    {
        assertEquals(0,Bill.getRevenues("TestFiles//revenues.txt"),0.1);
        bill.CalculateTotal();
        assertEquals(15.0,Bill.readRevenues("TestFiles//revenues.txt"),0.1);

    }

}