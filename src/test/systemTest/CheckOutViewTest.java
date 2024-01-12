package systemTest;

import Views.CheckOutView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Book;
import models.Category;
import models.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CheckOutViewTest extends ApplicationTest {

    Parent sceneRoot;
    Book book;
    Category category;
    Button proceedBt;
    Label errorLabel;
    TextField quantityTf;
    ArrayList<TextField> textFields;
    Text success;
    public void start(Stage stage){
        sceneRoot = new CheckOutView.ClickPane();
        Scene scene = new Scene(sceneRoot, 500, 500);
        stage.setScene(scene);
        stage.show();
        category = new Category("Fiction","TestFiles//fictionBooks.dat");
        book = new Book("1","t1",category,"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
        new CheckOutView(new Manager("n","s","e","b","i","p",1,"1"),stage, List.of(book)).getScene();

    }

    @BeforeEach
    public void setUpAll()
    {
        proceedBt = lookup("#proceedBt").queryAs(Button.class);
        errorLabel = lookup("#errorLabel").queryAs(Label.class);
        quantityTf = lookup("#quantityTf").queryAs(TextField.class);
        success = lookup("#success").queryAs(Text.class);

    }

    @Test
    public void test_InValidNumber()
    {
        quantityTf.clear();
        clickOn(quantityTf).write("-1");
        clickOn(proceedBt);
        Assertions.assertTrue(errorLabel.isVisible());
    }


    @Test
    public void test_ValidQuantity()
    {
        quantityTf.clear();
        clickOn(quantityTf).write("10");
        clickOn(proceedBt);
        Assertions.assertFalse(errorLabel.isVisible());
        assertEquals("The total is 150.0",success.getText());
    }

    @Test
    public void test_invalidQuantity()
    {
        quantityTf.clear();
        clickOn(quantityTf).write("11");
        clickOn(proceedBt);
        assertTrue(errorLabel.isVisible());
    }


}
