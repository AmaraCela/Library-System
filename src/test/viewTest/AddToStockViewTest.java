package viewTest;


import Views.AddToStockView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.assertions.api.Assertions.assertThat;

public class AddToStockViewTest extends ApplicationTest {

    Button button;
    @Override
    public void start(Stage stage)
    {
        Parent sceneRoot = new AddToStockView.ClickPane();
        Scene scene = new Scene(sceneRoot,200,200);
        stage.setScene(scene);
        stage.show();
    }


    @BeforeEach
    public void setUp()
    {
        button = lookup(".button").queryAs(Button.class);
    }

    @Test
    void test()
    {
        assertThat(button).hasText("Enter");
    }
}
