package controllerTest;

import Controllers.CategoryController;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {
    CategoryController categoryController;

    Category category;
    @BeforeEach
    void setUp()
    {
        category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
    }

    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//fiction.dat");
        file.delete();
        categoryController.updateCategories();
    }

    @Test
    void test_DeleteCategory()
    {
        categoryController.addCategories(category);
        categoryController.DeleteCategory(List.of(category));
        assertEquals(new ArrayList<Category>(), CategoryController.getCategories());
    }

    @Test
    void test_updateCategoryBinaryFile()
    {

        categoryController.addCategories(category);
        CategoryController.updateCategoryBinaryFile();
        categoryController.updateCategories();
        assertEquals(List.of(category), CategoryController.getCategories());

    }

    @Test
    void test_addCategory()
    {
        CategoryController.addCategory(category);
        assertEquals(List.of(category), CategoryController.getCategories());
    }


    //equivalence class testing
    @Test
    void test_handleCategoryWithEmptyString()
    {
        assertFalse(CategoryController.handleCategory(""));
    }

    @Test
    void test_handleCategoryWithPresentCategoryEntered()
    {
        categoryController.addCategories(category);
        assertFalse(CategoryController.handleCategory("Fiction"));
    }

    @Test
    void test_handleCategoryWithNewCategoryEntered()
    {
        categoryController.addCategories(category);
        assertTrue(CategoryController.handleCategory("Science"));
    }



    @Test
    void test_writeCategoryToBinaryFile()
    {
        CategoryController.writeCategoryToBinaryFile(category);
        categoryController.updateCategories();
        Category category1 = new Category("Science","TestFiles//scienceBooks.dat");
        CategoryController.writeCategoryToBinaryFile(category1);
        categoryController.updateCategories();
        assertEquals(List.of(category, category1),CategoryController.getCategories());

    }

    @Test
    void test_writeCategoryToBinaryFileNotFound()
    {
        CategoryController.writeCategoryToBinaryFile(category);
    }

    //equivalence class testing
    @Test
    void test_getCategoryNamesWhenEmpty()
    {
        assertEquals(new ArrayList<String>(),CategoryController.getCategoryNames());
    }

    @Test
    void test_getCategoryNamesWhenCategories()
    {
        categoryController.addCategories(category);
        assertEquals(List.of("Fiction"), CategoryController.getCategoryNames());
    }


    //equivalence class testing
    @Test
    void test_getCategoryWhenCategoryNotPresent()
    {
        categoryController.addCategories(category);
        assertNull(CategoryController.getCategory("Science"));
    }

    @Test
    void test_getCategoryWhenPresent()
    {
        categoryController.addCategories(category);
        assertEquals(new Category("Fiction","TestFiles//fictionBooks.dat"),CategoryController.getCategory("Fiction"));
    }

    @Test
    void test_updateCategoriesEmptyFile()
    {
        categoryController.updateCategories();
        assertEquals(new ArrayList<Category>(),CategoryController.getCategories());
    }

    @Test
    void test_updateCategories()
    {
        categoryController.addCategories(category);
        assertEquals(List.of(category),CategoryController.getCategories());
    }
}
