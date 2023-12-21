package controllerTest;

import Controllers.CategoryController;
import Controllers.SupplyBooksController;
import mockFiles.MockBook;
import mockFiles.MockCategory;
import models.Book;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.List;

public class SupplyBooksControllerTest {

    CategoryController category;
    SupplyBooksController supplyBooksController;
    Category category1;
    Category category2;
    Book book1;
    Book book2;

    @BeforeEach
    void setUpComponents() {
        supplyBooksController = new SupplyBooksController();
        category1 = new MockCategory("Fiction", "TestFiles//FictionBooks.dat");
        category2 = new MockCategory("Drama", "TestFiles//DramaBooks.dat");
        book1 = new MockBook("1111", "Book1", category1, "supplier", 10, 15, 15, "a", 3, "TestFiles//cost.txt");
        book2 = new MockBook("2222", "Book2", category2, "supplier", 10, 15, 15, "a", 4, "TestFiles//cost.txt");
        category1.addBookToCategory(book1);
        category2.addBookToCategory(book2);
        category = new CategoryController(new File("TestFiles//categoryController.dat"));
        category.addCategories(category1);
        category.addCategories(category2);
    }

    @AfterEach
    void dropDown() {
        category1.getBooksOfCategoryBinaryFile().delete();
        category2.getBooksOfCategoryBinaryFile().delete();
        category.getBinaryFile().delete();
    }

    @Test
    void test_addBooks() {
        Assertions.assertEquals(List.of(book1, book2), supplyBooksController.addBooks());
    }

    @ParameterizedTest
    @CsvSource({
            "1142",
            "2444"
    })
    void test_validateValidISBN(String ISBN) {
        supplyBooksController.addBooks();
        Assertions.assertTrue(supplyBooksController.validateISBN(ISBN));
    }


    @ParameterizedTest
    @CsvSource({
            "1111",
            "2222",
            "''"
    })
    void test_validateInvalidISBN(String ISBN) {
        supplyBooksController.addBooks();
        Assertions.assertFalse(supplyBooksController.validateISBN(ISBN));
    }

    @ParameterizedTest
    @CsvSource({
            "input1i",
            "input2input2input2"
    })
    void test_validateValidTitleAndSupplier(String input) {
        supplyBooksController.addBooks();
        Assertions.assertTrue(supplyBooksController.validateTitle(input));
        Assertions.assertTrue(supplyBooksController.validateSupplier(input));
    }

    @ParameterizedTest
    @CsvSource({
            "Book1Book1habgoowurito3bfyrks93nfosmfu2900",
            "''"
    })
    void test_validateInvalidTitleAndSupplier(String input) {
        supplyBooksController.addBooks();
        Assertions.assertFalse(supplyBooksController.validateTitle(input));
        Assertions.assertFalse(supplyBooksController.validateSupplier(input));
    }

    @ParameterizedTest
    @CsvSource({
            "124.5",
            "16.33",
            "0"
    })
    void test_validateValidPrices(double price) {
        Assertions.assertTrue(supplyBooksController.validatePurchasePrice(price));
        Assertions.assertTrue(supplyBooksController.validateOriginalPrice(price));
        Assertions.assertTrue(supplyBooksController.validateSellingPrice(price));
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "-21.1"
    })
    void test_validateInvalidPrices(double price) {
        Assertions.assertFalse(supplyBooksController.validatePurchasePrice(price));
        Assertions.assertFalse(supplyBooksController.validateOriginalPrice(price));
        Assertions.assertFalse(supplyBooksController.validateSellingPrice(price));
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "12",
            "21"
    })
    void test_validateValidStock(int stock) {
        Assertions.assertTrue(supplyBooksController.validateStock(stock));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "-1",
            "-2"
    })
    void test_validateInvalidStock(int stock) {
        Assertions.assertFalse(supplyBooksController.validateStock(stock));
    }

    @ParameterizedTest
    @CsvSource({
            "Auth1auth1habgoowurito3bfyrks93nfosmfu2900",
            "author",
            "a"
    })
    void test_validateValidAuthor(String author) {
        Assertions.assertTrue(supplyBooksController.validateAuthor(author));
    }

    @Test
    void test_validateInvalidAuthor() {
        Assertions.assertFalse(supplyBooksController.validateAuthor(""));
    }

    @ParameterizedTest
    @CsvSource({
            "Fiction",
            "Drama",
            "Romance"
    })
    void test_validateValidCategory(String categoryName) {
        supplyBooksController.addBooks();
        Assertions.assertTrue(supplyBooksController.validateCategory(categoryName));
    }

    @Test
    void test_validateInvalidCategory() {
        supplyBooksController.addBooks();
        Assertions.assertFalse(supplyBooksController.validateCategory(""));
        Assertions.assertFalse(supplyBooksController.validateCategory(null));
    }
    @Test
    void test_supply(){
        supplyBooksController.addBooks();
        Book book3 = new Book("3333","Book3",category2,"s",100.32,213.3,123.1,"a",1);
        category2.addBookToCategory(book3);
        Assertions.assertEquals(List.of(book1,book2,book3),supplyBooksController.supply("3333","Book3",category2.getCategoryName(),"s",100.32,213.3,123.1,"a",1));
    }
}
