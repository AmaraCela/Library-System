package viewTest;

import Views.AddToStockView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mockFiles.MockCategory;
import models.Book;
import models.Category;
import models.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToStockViewTest extends ApplicationTest {

    Button button;
    Button button1;
    Label unSuccessfulLabel;
    TextField copiesTf;
    TableView tableView;
    Parent sceneRoot;

    @Override
    public void start(Stage stage)
    {
        sceneRoot = new AddToStockView.ClickPane();
        Scene scene = new Scene(sceneRoot,500,500);
        stage.setScene(scene);
        stage.show();
        new AddToStockView(new Manager("n","s","e","b","i","p",1,"1"),stage).getScene();
    }


    @BeforeEach
    public void setUp()
    {
        button = lookup("#addBt").queryAs(Button.class);
        button1 = lookup("#pageBt").queryAs(Button.class);
        unSuccessfulLabel = lookup("#unSuccessfulLabel").queryAs(Label.class);
        copiesTf = lookup("#copiesTf").queryAs(TextField.class);
        tableView = lookup("#bookTableView").queryAs(TableView.class);
//        controller = new AddToStockController();
    }

    @Test
    void test()
    {
        assertEquals("Add",button.getText());
        assertEquals("",button1.getText());
    }

//    @Test
//    void clickOnAddBt(){
//        clickOn(button);
//        assertEquals(button.getText(), "Clicked");
//    }
//
//    @Test
//    void clickOnPageBt(){
//        clickOn(button1);
//        assertEquals(button1.getText(), "Clicked");
//    }

    @Test
    void test_unSuccessfulLabelVisibilityFalse(){
        Category category = new MockCategory("Fiction","TestFiles//fictionBooks.dat");
        Book book = new Book("1","t1",category,"s1",10,15,15,"a1",10,"TestFiles//cost.txt");
        tableView.getItems().add(book);
        tableView.getSelectionModel().select(0);
        System.out.println(tableView.getSelectionModel().getSelectedItems());
        clickOn(copiesTf).write("0");
        clickOn(button);
        System.out.println(unSuccessfulLabel.isVisible());
        assertTrue(unSuccessfulLabel.isVisible());
    }
}
