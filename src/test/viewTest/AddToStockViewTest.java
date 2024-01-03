package viewTest;


import Views.AddToStockView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddToStockViewTest extends ApplicationTest {

    Button button;
    Button button1;
    Label unSuccessfulLabel;
    TextField copiesTf;
//    TableView<Book> tableView;
    @Override
    public void start(Stage stage)
    {
        Parent sceneRoot = new AddToStockView.ClickPane();
        Scene scene = new Scene(sceneRoot,500,500);
        System.out.println(sceneRoot.getChildrenUnmodifiable());
        stage.setScene(scene);
        stage.show();
    }


    @BeforeEach
    public void setUp()
    {
        button = lookup("#addBt").queryAs(Button.class);
        button1 = lookup("#pageBt").queryAs(Button.class);
        unSuccessfulLabel = lookup("#unSuccessfulLabel").queryAs(Label.class);
        copiesTf = lookup("#copiesTf").queryAs(TextField.class);
//        tableView = lookup("#bookTableView").queryAs(TableView.class);
    }

    @Test
    void test()
    {
        assertEquals(button.getText(), "Add");
        assertEquals(button1.getText(), "");
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
//        tableView.getSelectionModel().clearAndSelect(1);
        clickOn(copiesTf).write("2");
        clickOn(button);
        System.out.println(unSuccessfulLabel.isVisible());
        assertFalse(unSuccessfulLabel.isVisible());
    }
}
