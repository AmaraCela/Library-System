package viewTest;

import Views.LogInView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInViewTest extends ApplicationTest {

    Parent sceneRoot;
    TextField usernameTf;
    TextField passwordTf;
    Button logInBt;
    Label loginSuccessful;
    public void start(Stage stage){
        sceneRoot = new LogInView.ClickPane();
        Scene scene = new Scene(sceneRoot, 500, 500);
        stage.setScene(scene);
        new LogInView(stage);
        stage.show();
    }

    @BeforeEach
    void setUp(){
        logInBt = lookup("#logInBt").queryAs(Button.class);
        usernameTf = lookup("#usernameTf").queryAs(TextField.class);
        passwordTf = lookup("#passwordTf").queryAs(TextField.class);
        loginSuccessful = lookup("#loginSuccessful").queryAs(Label.class);
    }

    @Test
    void test_login(){
        usernameTf.setText("acela21");
        passwordTf.setText("12345678");
        clickOn(logInBt);
        assertTrue(loginSuccessful.isVisible());
    }
}
