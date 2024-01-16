package mockFiles;

import Controllers.CategoryController;
import models.Category;

import java.util.ArrayList;
import java.util.List;

public class MockCategoryController extends CategoryController {
    static List<Category> categories = new ArrayList<>();
    public MockCategoryController()
    {

    }




    @Override
    public List<Category> addCategories(Category category)
    {
        categories.add(category);
        return categories;
    }

    @Override
    public void DeleteCategory(List<Category> selectedCategories)
    {
        categories.removeAll(selectedCategories);
    }

}
