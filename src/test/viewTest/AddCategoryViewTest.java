package viewTest;

import Views.AddCategoryView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Category;
import models.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AddCategoryViewTest extends ApplicationTest {

    Parent sceneRoot;
    Button addBt;
    TableView<Category> categoryTableView;
    Label successfulLabel;
    Label unsuccessfulLabel;
    TextField categoryTf;
    Button deleteBt;
    Button administratorPageBt;
    public void start(Stage stage){
        sceneRoot = new AddCategoryView.ClickPane();
        Scene scene = new Scene(sceneRoot, 500, 500);
        stage.setScene(scene);
        stage.show();
        new AddCategoryView(new Manager("n","s","e","b","i","p",1,"1"),stage).getScene();
    }

    @BeforeEach
    void setUp(){
        addBt = lookup("#addBt").queryAs(Button.class);
        successfulLabel = lookup("#success").queryAs(Label.class);
        unsuccessfulLabel = lookup("#failure").queryAs(Label.class);
        categoryTableView = lookup("#categoryTableView").queryAs(TableView.class);
        categoryTf = lookup("#categoryTf").queryAs(TextField.class);
        deleteBt = lookup("#deleteBt").queryAs(Button.class);
        administratorPageBt = lookup("#administratorPateBt").queryAs(Button.class);
    }

    @Test
    void test_AddBtClick(){
        assertEquals(addBt.getText(), "Add");
    }

    @Test
    void test_administratorPageBtClick(){
        assertEquals(administratorPageBt.getText(), "");
    }
    @Test
    void test_addCategorySuccessfully(){
        categoryTf.setText("Drama");
        clickOn(addBt);
//        categoryTableView.getSelectionModel().select(0);
//        System.out.println(categoryTableView.getSelectionModel().getSelectedItems());
        assertTrue(successfulLabel.isVisible());
        assertFalse(unsuccessfulLabel.isVisible());
    }

    @Test
    void test_addCategoryUnsuccessfully(){
        categoryTf.setText("");
        clickOn(addBt);
//        categoryTableView.getSelectionModel().select(0);
//        System.out.println(categoryTableView.getSelectionModel().getSelectedItems());
        assertFalse(successfulLabel.isVisible());
        assertTrue(unsuccessfulLabel.isVisible());
    }

    @Test
    void test_deleteCategory(){
        categoryTableView.getSelectionModel().select(0);
        System.out.println(categoryTableView.getSelectionModel().getSelectedItems());
        ArrayList<Category>categories = new ArrayList<>();
        categories.addAll(categoryTableView.getItems());
        System.out.println(categories);
        clickOn(deleteBt);
        ArrayList<Category>categoriesAfterDelete = new ArrayList<>();
        categoriesAfterDelete.addAll(categoryTableView.getItems());
        System.out.println(categoriesAfterDelete);
        assertNotEquals(categories, categoriesAfterDelete);
    }


}
