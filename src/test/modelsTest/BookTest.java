package modelsTest;

import mockFiles.MockCategory;
import models.Book;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {
    Book book;
    @BeforeEach
    void setUp()
    {
        Category category = new MockCategory("Fiction","TestFiles//fictionBooks.dat");
        book = new Book("1","t1",category,"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
    }

    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//fictionBooks.dat");
        file.delete();
        file = new File("TestFiles//cost.txt");
        file.delete();
        file = new File("TestFiles//cost1.txt");
        file.delete();
        Book.readFromFile("TestFiles//cost.txt");
    }
    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
    })

    void test_getISBN(String a)
    {
        book.setISBN(a);
        assertEquals(book.getISBN(), a);
    }


    @ParameterizedTest
    @CsvSource({
            "t1",
            "t2"
    })
    void test_getTitle(String t)
    {
        book.setTitle(t);
        assertEquals(book.getTitle(),t);
    }

    @ParameterizedTest
    @CsvSource({
            "c1",
            "c2"
    })
    void test_getCategory(String c)
    {
        Category category = new MockCategory(c);
        book.setCategory(category);
        assertEquals(category,book.getCategory());
    }

    @ParameterizedTest
    @CsvSource({
            "s1",
            "s2"
    })
    void test_getSupplier(String s)
    {
        book.setSupplier(s);
        assertEquals(s,book.getSupplier());
    }

    @ParameterizedTest
    @CsvSource({
            "10",
            "15"
    })
    void test_getPurchasedPrice(double p)
    {

        book.setPurchasedPrice(p);
        assertEquals(p,book.getPurchasedPrice());
    }


    @ParameterizedTest
    @CsvSource({
            "15",
            "20"
    })
    void test_getOriginalPrice(double p)
    {

        book.setOriginalPrice(p);
        assertEquals(p,book.getOriginalPrice());
    }


    @ParameterizedTest
    @CsvSource({
            "15",
            "20"
    })
    void test_getSellingPrice(double p)
    {

        book.setSellingPrice(p);
        assertEquals(p,book.getSellingPrice());
    }


    @ParameterizedTest
    @CsvSource({
            "a1",
            "a2"
    })
    void test_getAuthor(String a)
    {

        book.setAuthor(a);
        assertEquals(a,book.getAuthor());
    }


    @ParameterizedTest
    @CsvSource({
            "10",
            "15"
    })
    void test_getStock(int p)
    {
        book.setStock(p);
        assertEquals(p,book.getStock());
    }

    @ParameterizedTest
    @CsvSource({
            "1,9",
            "10,0",
            "11,-1",
            "-1,11"
    })
    void test_decreaseStock(int d, int r)
    {
        book.decreaseStock(d);
        assertEquals(book.getStock(),r);
    }

    @ParameterizedTest
    @CsvSource({
            "1,11",
            "-1,9"
    })
    void test_increaseStock(int a, int b)
    {
        book.increaseStock(a);
        assertEquals(book.getStock(),b);
    }

    @Test
    void test_getCategoryName()
    {
        assertEquals("Fiction",book.getCategoryName());
    }

    @Test
    void test_writeToFile()
    {
        Book.writeToFile("TestFiles/cost.txt");
        assertEquals(100,Book.readFromFile("TestFiles/cost.txt"));
    }

    @Test
    void writeToEmptyFile()
    {
        Book.writeToFile("TestFilesss/cost.txt");
    }



    @ParameterizedTest
    @CsvSource({
            "TestFiles//cost.txt",
            "TestFilessss//cost.txt"
    })
    void test_getCostFileName(String name)
    {
        book.setCostFileName(name);
        assertEquals(name, book.getCostFileName());
    }

    @Test
    void test_getTotalCost()
    {
        assertEquals(100.0, Book.getTotalCost(),0.1);
        new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
        assertEquals(200.0,Book.getTotalCost(),0.1);

    }


    @Test
    void test_equals()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
        assertEquals(book,book1);
    }

    @Test
    void test_equalsFalseISBN()
    {
        Book book1 = new Book("11","t11",new MockCategory("Fictionn","TestFiles//fictionBooks.dat"),"s11",100,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseTitle()
    {
        Book book1 = new Book("1","t11",new MockCategory("Fictionn","TestFiles//fictionBooks.dat"),"s11",100,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }
    @Test
    void test_equalsFalseCategory()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fictionn","TestFiles//fictionBooks.dat"),"s11",100,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseSupplier()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s11",100,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalsePurchasedPrice()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",100,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }
    @Test
    void test_equalsFalseOriginalPrice()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,150,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseSellingPrice()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,15,150,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseAuthor()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,15,15,"a11",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseStock()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s1",10,15,15,"a1",100,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_equalsFalseCostFileName()
    {
        Book book1 = new Book("1","t1",new MockCategory("Fiction","TestFiles//fictionBooks.dat"),"s11",10,15,15,"a1",10,"TestFiles//cost1.txt");
        assertNotEquals(book1,book);
    }

    @Test
    void test_notBook()
    {
        assertNotEquals(book,new Date());
    }
}
