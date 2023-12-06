package modelsTest;
import mockFiles.MockObjectStreamHandler;
import models.Book;
import models.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.util.reflection.Whitebox;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            "Fiction"
    })
    void test_updateCategory(String categoryName) throws IOException {
        Category category = new Category(categoryName);
        Book book = new Book("1111","book1",category,"supplier",1000.01,823,1200.7,"author1",2);
        MockObjectStreamHandler mockObjectStreamHandler = new MockObjectStreamHandler();
        Whitebox.setInternalState(category,"outputStream",mockObjectStreamHandler);
        category.writeToBinaryFile(book);
        List<Book> booksWritten = mockObjectStreamHandler.getBooks();
        assertEquals(0, booksWritten.size());
    }

}
