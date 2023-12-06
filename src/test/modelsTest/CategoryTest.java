package modelsTest;
import mock.MockFile;
import models.Book;
import models.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import java.io.*;
public class CategoryTest {

    @ParameterizedTest
    @CsvSource({
            "Fiction",
            "Drama"
    })
    void test_getCategoryName(String categoryName){
        Category category = new Category(categoryName);
        Assertions.assertEquals(category.getCategoryName(),categoryName);
    }

}
