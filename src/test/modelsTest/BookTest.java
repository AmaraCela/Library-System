package modelsTest;

import models.Book;
import models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    Book book;
    @BeforeEach
    void setUp()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        book = new Book("1","t1",category,"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
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
        Category category = new Category(c);
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

//        assertThrows(FileNotFoundException.class,()->Book.writeToFile("TestFilessss/cost.txt"));
    }

//    @Test
//    void test_getTotalCost()
//    {
//        assertEquals(100,Book.getTotalCost());
//    }


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

}
