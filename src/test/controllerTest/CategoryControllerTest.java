package controllerTest;

import Controllers.CategoryController;
import models.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {
    CategoryController categoryController;

    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//fiction.dat");
        file.delete();
    }

    @Test
    void test_DeleteCategory()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        categoryController.DeleteCategory(List.of(category));
        assertEquals(new ArrayList<Category>(), CategoryController.getCategories());
    }

    @Test
    void test_updateCategoryBinaryFile()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        CategoryController.updateCategoryBinaryFile();
        CategoryController.updateCategories();
        assertEquals(List.of(category), CategoryController.getCategories());

    }

    @Test
    void test_addCategory()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
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
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertFalse(CategoryController.handleCategory("Fiction"));
    }

    @Test
    void test_handleCategoryWithNewCategoryEntered()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertTrue(CategoryController.handleCategory("Science"));
    }


    @Test
    void test_writeCategoryToBinaryFile()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        CategoryController.writeCategoryToBinaryFile(category);
        CategoryController.updateCategories();
        assertEquals(List.of(category),CategoryController.getCategories());
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
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertEquals(List.of("Fiction"), CategoryController.getCategoryNames());
    }


    //equivalence class testing
    @Test
    void test_getCategoryWhenCategoryNotPresent()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertNull(CategoryController.getCategory("Science"));
    }

    @Test
    void test_getCategoryWhenPresent()
    {
        Category category = new Category("Fiction","TestFiles//fictionBooks.dat");
        categoryController = new CategoryController(new File("TestFiles//fiction.dat"));
        categoryController.addCategories(category);
        assertEquals(new Category("Fiction","TestFiles//fictionBooks.dat"),CategoryController.getCategory("Fiction"));
    }

}
