package modelsTest;
import models.Book;
import models.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CategoryTest {

    @ParameterizedTest
    @CsvSource({
            "Fiction",
            "Drama"
    })
    void test_getCategoryName(String categoryName){
        Category category = new Category(categoryName);
        assertEquals(category.getCategoryName(),categoryName);
    }

    @ParameterizedTest
    @CsvSource({
            "Fiction, TestFiles/booksFiction.dat"
    })
    void test_writeToBinaryFile(String categoryName, String fileName) throws IOException {
        Category category = new Category(fileName, categoryName);
        Book book = new Book("1111","book1",category,"supplier",1000.01,823,1200.7,"author1",2);
        System.out.println(category.getBinaryFile());
        category.writeBookToBinaryFile(book);
        assertEquals(book, category.readBinaryFile());
    }

}
