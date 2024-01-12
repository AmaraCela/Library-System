package systemTest;

import Views.LogInView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class LogInViewTest extends ApplicationTest {

    Parent sceneRoot;
    TextField usernameTf;
    TextField passwordTf;
    Button logInBt;
    Text loginSuccessful;
    Text loginFailed;
    public void start(Stage stage){
        sceneRoot = new LogInView.ClickPane();
        Scene scenee = new Scene(sceneRoot, 500, 500);
        stage.setScene(scenee);
        new LogInView(stage);
        stage.show();
    }
    @BeforeEach
    void setUp(){
        logInBt = lookup("#logInBt").queryAs(Button.class);
        usernameTf = lookup("#usernameTf").queryAs(TextField.class);
        passwordTf = lookup("#passwordTf").queryAs(TextField.class);
        loginSuccessful = (Text) sceneRoot.getChildrenUnmodifiable().get(0);
        loginFailed = (Text) sceneRoot.getChildrenUnmodifiable().get(1);
    }

    @AfterEach
    void clearUp(){
        usernameTf.clear();
        passwordTf.clear();
    }
    @Test
    void test_loginSuccessfully(){
        clickOn(usernameTf).write("acela21");
        clickOn(passwordTf).write("12345678");
        clickOn(logInBt);
        Assertions.assertTrue(loginSuccessful.isVisible());
        Assertions.assertFalse(loginFailed.isVisible());
    }
    @Test
    void test_loginUnsuccessfully(){
        clickOn(usernameTf).write("amjeshtri21");
        clickOn(passwordTf).write("12345678");
        clickOn(logInBt);
        Assertions.assertTrue(loginFailed.isVisible());
        Assertions.assertFalse(loginSuccessful.isVisible());
    }
}
