package modelsTest;

import mockFiles.MockBook;
import models.Book;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
    void test_getCategoryName()
    {
        assertEquals("Fiction", category.getCategoryName());
        category.setCategoryName("Category");
        assertEquals("Category",category.getCategoryName());
    }
    @Test
    void test_addBookToCategory()
    {
        Book book = new MockBook("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        ArrayList<Book> books = new ArrayList<>();
        category.addBookToCategory(book);
        books.add(book);
        assertEquals(books,category.getBooksOfCategory());
        assertEquals(books.size(),category.numOfBooks());
    }

    @Test
    void test_getBookOfCategory()
    {
        Book book = new MockBook("i","t",category,"s",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book);
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
        category.writeBookToBinaryFile(book);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        assertEquals(books, category.readBooks());
    }

    @Test
    void test_updateBinaryFile(){
        Book book1 = new Book("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new Book("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        List<Book> books = List.of(book1,book2);
        category.updateBinaryFile();
        assertEquals(books, category.readBooks());
    }

    @Test
    void test_equals()
    {
        assertTrue(category.equals(new Category("Fiction","TestFiles//fictionBooks.dat")));
    }

    @Test
    void test_notEquals()
    {
        assertFalse(category.equals(new Date()));
    }

    @Test
    void test_updateBooksOfCategory()
    {
        Book book1 = new MockBook("1111","Book1",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        Book book2 = new MockBook("2222","Book2",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.addBookToCategory(book1);
        category.addBookToCategory(book2);
        Book book3 = new MockBook("3333","Book3",category,"supplier",10,15,15,"a",1,"TestFiles//cost.txt");
        category.updateBooksOfCategory(1,book3);
        ArrayList<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book3);
        assertEquals(list,category.getBooksOfCategory());

    }
}

