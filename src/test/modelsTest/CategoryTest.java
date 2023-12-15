package modelsTest;

import models.Book;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    Category category;

    @BeforeEach
    void setUp()
    {
        category = new Category("Fiction", "TestFiles//fictionBooks.dat");
    }

    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//fictionBooks.dat");
        file.delete();
        File file1 = new File("TestFiles//cost.txt");
        file1.delete();
    }

    @Test
    void test_addBookToCategory()
    {
        Book book = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        assertEquals(books,category.getBooksOfCategory());
        assertEquals(books.size(),category.numOfBooks());
    }

    @Test
    void test_getBookOfCategory()
    {
        Book book = new Book("i","t",category,"s",10,15,15,"a",1,"TestFiles//cost.txt");
        assertEquals(book,category.getBookOfCategory("i"));
        assertNull(category.getBookOfCategory("a"));
    }

    @Test
    void test_getBooksOfCategoryBinaryFile()
    {
        assertEquals(new File("TestFiles//fictionBooks.dat"), category.getBooksOfCategoryBinaryFile());
    }



    @Test
    void test_writeBookToBinaryFile()
    {
        Book book = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        assertEquals(books.get(0), category.readBooks().get(0));
    }

    @Test
    void test_updateBinaryFile(){
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        List<Book> books = List.of(book1,book2);
        category.updateBinaryFile();
        assertEquals(books, category.readBooks());
    }
}
