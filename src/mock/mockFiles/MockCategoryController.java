package mockFiles;

import Controllers.CategoryController;
import models.Category;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MockCategoryController extends CategoryController {
    static List<Category> categories = new ArrayList<>();
    public MockCategoryController(File categoryFile)
    {

    }

//    @Override
//    public List<Category> addCategories(Category category)
//    {
//        categories.add(category);
//        return categories;
//    }
//
//    public static ArrayList<Category> getCategories()
//    {
//        return (ArrayList<Category>) categories;
//    }
}
