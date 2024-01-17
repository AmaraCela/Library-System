package systemTest;

import Controllers.RegisterStaffController;
import Views.LogInView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Administrator;
import org.junit.jupiter.api.*;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.File;

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
        RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));

        logInBt = lookup("#logInBt").queryAs(Button.class);
        usernameTf = lookup("#usernameTf").queryAs(TextField.class);
        passwordTf = lookup("#passwordTf").queryAs(TextField.class);
        loginSuccessful = (Text) sceneRoot.getChildrenUnmodifiable().get(0);
        loginFailed = (Text) sceneRoot.getChildrenUnmodifiable().get(1);
    }

    @AfterEach
    void clearUp(){

        File file = new File("TestFiles//usernames.txt");
        file.delete();
        file = new File("TestFiles//employees.dat");
        file.delete();

        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        usernameTf.clear();
        passwordTf.clear();

        RegisterStaffController.readFromFile();

    }

    @AfterAll
    static void returnOriginalFiles(){
        RegisterStaffController.readFromFile();
    }

    @Test
    void test_loginSuccessfully(){

        new Administrator("Amara", "Cela", "acela@gmail.com", "29/12/2001", "acela21", "12345678", 3000, "067 71 71 711");
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
