package Controllers;

import Auxilaries.HeaderlessObjectOutputStream;
import Views.AddCategoryView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Category;
import models.Controller;
import models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryController extends Controller //ok
{

    private static File binaryFile = new File("categories.dat");
    private static ArrayList<Category> categories = new ArrayList<>();
    private AddCategoryView categoryView;

    public CategoryController(Person administrator, AddCategoryView addCategoryView)
    {

        CategoryController.binaryFile =  new File("categories.dat");
        this.categoryView = addCategoryView;
        this.categoryView.getAddBt().setOnAction(e->
        {
            addCategories();
        });

        this.categoryView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(categoryView,administrator);

        });

        this.categoryView.getDeleteBt().setOnAction(e->
        {
            ObservableList<Category> selectedCategories = this.categoryView.getCategoryTableView().getSelectionModel().getSelectedItems();
            DeleteCategory(selectedCategories);
            this.categoryView.getCategoryTableView().getItems().clear();
            this.categoryView.getCategoryTableView().getItems().addAll(FXCollections.observableList(categories));
        });
    }
    public CategoryController(File binaryFile){
        CategoryController.binaryFile = binaryFile;
    }

    public void DeleteCategory(List<Category> selectedCategories)
    {
        categories.removeAll(selectedCategories);
        updateCategoryBinaryFile();

    }



    //writes all categories
    public static void updateCategoryBinaryFile()
    {
        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(binaryFile,false);)
        {
            outputStream = new ObjectOutputStream(output);

            for (int i=0 ;i< categories.size();i++)
            {
                outputStream.writeObject(categories.get(i));
            }
            outputStream.close();
        }
        catch (NotSerializableException e)
        {
            System.out.println("Category not serializable");
        }
        catch (IOException e)
        {
            System.out.println("IOException in writing categories");

        }
    }

    public static void addCategory(Category category)
    {
        categories.add(category);
        writeCategoryToBinaryFile(category);
    }

    public static boolean handleCategory(String name)
    {
        if (name.length()==0)
        {
            return false;
        }
        for (int i =0;i< categories.size();i++)
        {
            if(categories.get(i).getCategoryName().equals(name))
            {
                return false;
            }
        }

        return true;
    }


    ///Must be included when opening the program
    //reads all categories from category file
    public static void updateCategories()
    {
        categories.clear();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(binaryFile)))
        {
            int count = -1000000000;
            Category category = (Category) inputStream.readObject();
            categories.add(category);
            category.readBooks();
            count++;
        }
        catch (EOFException e)
        {
            System.out.println("End of file exception in reading categories");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found in reading categories");
        }
        catch (IOException e)
        {
            System.out.println("IOException in reading categories");
        }
    }

    //writes a newly added category to the category file
    public static void writeCategoryToBinaryFile(Category category)
    {

        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(binaryFile,true);)
        {
            if(binaryFile.length()<=0)
            {
                outputStream = new ObjectOutputStream(output);
            }
            else
            {
                outputStream = new HeaderlessObjectOutputStream(output);
            }

            outputStream.writeObject(category);

            outputStream.close();
        }
        catch (NotSerializableException e)
        {
            System.out.println("Not serializable category");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found in writing categories");
        }
        catch (IOException e)
        {
            System.out.println("IOException in writing categories");

        }


    }

    public static ArrayList<Category> getCategories() {

        return categories;
    }

    public static ArrayList<String> getCategoryNames()
    {
        ArrayList <String > str = new ArrayList<>();
        for(int i=0;i<categories.size();i++)
        {
            str.add(categories.get(i).getCategoryName());

        }
        return str;
    }
    public static Category getCategory(String categoryName)
    {
        for(int i = 0; i< categories.size();i++)
        {
            if(categories.get(i).getCategoryName().equals(categoryName))
            {
                return categories.get(i);
            }
        }
        return null;
    }

    public ObservableList<Category> addCategories()
    {
        this.categoryView.getSuccessfulLabel().setVisible(false);
        this.categoryView.getUnsuccessfulLabel().setVisible(false);
        String categoryName = this.categoryView.getCategoryTf().getText();
        if(handleCategory(categoryName))
        {
            this.categoryView.getSuccessfulLabel().setVisible(true);
            this.categoryView.getCategoryTableView().getItems().clear();
            this.categoryView.getCategoryTableView().getItems().addAll(FXCollections.observableList(categories));
            Category category = new Category(categoryName);
            addCategory(category);
        }
        else
        {
            this.categoryView.getUnsuccessfulLabel().setVisible(true);
        }

        return this.categoryView.getCategoryTableView().getItems();
    }
//    List<Category> categoryList = new ArrayList<>();
    public List<Category> addCategories(Category category){
        categories.clear();
        categories.add(category);
        return categories;
    }

}
