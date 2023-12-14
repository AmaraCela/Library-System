package controllerTest;

import Controllers.CategoryController;
import models.Category;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryControllerTest {
    CategoryController categoryController = new CategoryController(new File("TestFiles//fiction.dat"));

    @Test
    void test_DeleteCategory()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController.addCategories(category);
        categoryController.DeleteCategory(List.of(category));
        assertEquals(new ArrayList<Category>(), CategoryController.getCategories());
    }

}
