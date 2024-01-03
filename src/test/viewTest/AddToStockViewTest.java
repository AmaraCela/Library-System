package viewTest;


import Views.AddToStockView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToStockViewTest extends ApplicationTest {

    Button button;
    Button button1;
    @Override
    public void start(Stage stage)
    {
        Parent sceneRoot = new AddToStockView.ClickPane();
        Scene scene = new Scene(sceneRoot,200,200);
        System.out.println(sceneRoot.getChildrenUnmodifiable());
        stage.setScene(scene);
        stage.show();
    }


    @BeforeEach
    public void setUp()
    {
        button = lookup("#addBt").queryAs(Button.class);
        button1 = lookup("#pageBt").queryAs(Button.class);
    }

    @Test
    void test()
    {
        assertEquals(button.getText(), "Add");
        assertEquals(button1.getText(), "");
    }
}
