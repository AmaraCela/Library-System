package systemTest;

import Views.RegisterStaffView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterStaffViewTest extends ApplicationTest {

    Parent sceneRoot;
    TextField usernameTf;
    PasswordField passwordTf;

    TextField nameTf;
    TextField surnameTf;
    TextField emailTf;
    TextField phoneNoTf;
    TextField birthdayTf;
    TextField salaryTf;
    Button signUpBt;
    Label usernameErrorLabel;
    Label passwordErrorLabel;
    Label nameErrorLabel;
    Label surnameErrorLabel;
    Label emailErrorLabel;
    Label birthdayErrorLabel;
    Label phonenoErrorLabel;
    Label salaryErrorLabel;
    ImageView salaryError;
    ImageView usernameError;
    ImageView passwordError;
    ImageView nameError;
    ImageView surnameError;
    ImageView birthdayError;
    ImageView emailError ;
    ImageView phoneError;
    Text successful;
    Text unsuccessfulText;
    @Override
    public void start(Stage stage)
    {
        sceneRoot = new RegisterStaffView.ClickPane();
        Scene scene = new Scene(sceneRoot,500,500);
        stage.setScene(scene);
        stage.show();
        new RegisterStaffView(new Manager("n","s","e","b","i","p",1,"1"),stage,1);
    }



    @BeforeEach
    public void setup()
    {
        usernameTf = lookup("#usernameTf").queryAs(TextField.class);
        usernameTf.clear();
        passwordTf = lookup("#passwordTf").queryAs(PasswordField.class);
        passwordTf.clear();
        nameTf = lookup("#nameTf").queryAs(TextField.class);
        nameTf.clear();
        surnameTf = lookup("#surnameTf").queryAs(TextField.class);
        surnameTf.clear();
        emailTf = lookup("#emailTf").queryAs(TextField.class);
        emailTf.clear();
        phoneNoTf = lookup("#phoneNoTf").queryAs(TextField.class);
        phoneNoTf.clear();
        birthdayTf = lookup("#birthdayTf").queryAs(TextField.class);
        birthdayTf.clear();
        salaryTf = lookup("#salaryTf").queryAs(TextField.class);
        salaryTf.clear();
        signUpBt = lookup("#signUpBt").queryAs(Button.class);
        usernameErrorLabel = lookup("#usernameErrorLabel").queryAs(Label.class);
        passwordErrorLabel = lookup("#passwordErrorLabel").queryAs(Label.class);
        nameErrorLabel = lookup("#nameErrorLabel").queryAs(Label.class);
        surnameErrorLabel = lookup("#surnameErrorLabel").queryAs(Label.class);
        emailErrorLabel = lookup("#emailErrorLabel").queryAs(Label.class);
        birthdayErrorLabel = lookup("#birthdayErrorLabel").queryAs(Label.class);
        phonenoErrorLabel = lookup("#phonenoErrorLabel").queryAs(Label.class);
        salaryErrorLabel = lookup("#salaryErrorLabel").queryAs(Label.class);
        salaryError = lookup("#salaryError").queryAs(ImageView.class);
        usernameError = lookup("#usernameError").queryAs(ImageView.class);
        passwordError = lookup("#passwordError").queryAs(ImageView.class);
        nameError = lookup("#nameError").queryAs(ImageView.class);
        surnameError = lookup("#surnameError").queryAs(ImageView.class);
        birthdayError = lookup("#birthdayError").queryAs(ImageView.class);
        emailError = lookup("#emailError ").queryAs(ImageView.class);
        phoneError = lookup("#phoneError").queryAs(ImageView.class);
//        successful = lookup("#successful").queryText();
//        unsuccessfulText = lookup("#unsuccessfulText").queryAs(Text.class);
    }

    @Test
    void test_validValues()
    {
        clickOn(usernameTf).write("librarian1");
        clickOn(passwordTf).write("12345678");
        clickOn(nameTf).write("lib1");
        clickOn(surnameTf).write("lib2");
        clickOn(emailTf).write("lib@gmail.com");
        clickOn(phoneNoTf).write("067 77 77 777");
        clickOn(birthdayTf).write("20 12 2000");
        clickOn(salaryTf).write("200");
        clickOn(signUpBt);
//        assertTrue(successful.isVisible());
    }

    @Test
    void test_invalidValues()
    {
        clickOn(usernameTf).write("i");
        clickOn(passwordTf).write("1");
        clickOn(nameTf).write("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        clickOn(surnameTf).write("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        clickOn(emailTf).write("l");
        clickOn(phoneNoTf).write("1");
        clickOn(birthdayTf).write("1");
        clickOn(salaryTf).write("1");
        clickOn(signUpBt);
        clickOn(usernameError);
        assertTrue(usernameErrorLabel.isVisible());
        clickOn(passwordError);
        assertTrue(passwordErrorLabel.isVisible());
        clickOn(nameError);
        assertTrue(nameErrorLabel.isVisible());
        clickOn(surnameError);
        assertTrue(surnameErrorLabel.isVisible());
        clickOn(emailError);
        assertTrue(emailErrorLabel.isVisible());
        clickOn(phoneError);
        assertTrue(phonenoErrorLabel.isVisible());
        clickOn(birthdayError);
        assertTrue(birthdayErrorLabel.isVisible());
        clickOn(salaryError);
        assertTrue(salaryErrorLabel.isVisible());


    }
}
