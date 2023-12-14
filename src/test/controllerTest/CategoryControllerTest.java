package controllerTest;

import Controllers.CategoryController;
import models.Category;
import org.junit.jupiter.api.Test;

import java.io.File;

public class CategoryControllerTest {
    CategoryController categoryController = new CategoryController(new File("TestFiles//fiction.dat"));

    @Test
    void test_DeleteCategory()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");

    }

}
