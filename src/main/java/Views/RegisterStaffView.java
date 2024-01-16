package Views;

import Controllers.RegisterStaffController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Person;

public class RegisterStaffView extends BorderPane {

    private final Stage stage;

    private static final Image image = new Image("file:errorIcon.jpg");

    private static  TextField usernameTf = new TextField();
    private static  PasswordField passwordTf = new PasswordField();
    private static  TextField nameTf = new TextField();
    private static  TextField surnameTf = new TextField();
    private static  TextField emailTf = new TextField();
    private static  TextField phoneNoTf = new TextField();
    private static  TextField birthdayTf = new TextField();
    private static  TextField salaryTf = new TextField();

    private static final Button signUpBt = new Button("Sign Up");
    private static final Label usernameErrorLabel = new Label("Username not available!");

    private static final Label passwordErrorLabel = new Label("Password must have at least 8 characters!");

    private static final Label nameErrorLabel = new Label("Name can not have this length!");



    private static final Label surnameErrorLabel = new Label("Last name can not have this length!");

    private static final Label emailErrorLabel = new Label("Enter a valid email!");


    private static final Label birthdayErrorLabel = new Label("Accepted birthday format is dd/mm/yyyy.");

    private static final Label phonenoErrorLabel = new Label("Accepted number format is 06d dd dd ddd.");



    private static final Label salaryErrorLabel = new Label("Enter a valid salary!");

    private static final ImageView salaryError = new ImageView(image);


    private static final ImageView usernameError = new ImageView(image);

    private static final ImageView passwordError = new ImageView(image);

    private static final ImageView nameError = new ImageView(image);

    private static final ImageView surnameError = new ImageView(image);


    private static final ImageView birthdayError = new ImageView(image);


    private static final ImageView emailError = new ImageView(image);


    private static final ImageView phoneError = new ImageView(image);

    private static Text successful = new Text("Registration successful!");
    private static final Text unsuccessfulText = new Text("Registration unsuccessful! Check the above fields again!");

    private final Button administratorPageBt = new Button();

    private RegisterStaffController controller;

        public RegisterStaffView (Person person, Stage stage, int choice)
        {
            this.stage = stage;
            usernameTf = new TextField();
            passwordTf = new PasswordField();
            nameTf = new TextField();
            surnameTf = new TextField();
            emailTf = new TextField();
            phoneNoTf = new TextField();
            birthdayTf = new TextField();
            salaryTf = new TextField();

            GridPane gridPane = new GridPane();
            gridPane.setHgap(0);
            gridPane.setVgap(3);

            Rectangle rectangle = new Rectangle(500,500);
            rectangle.setFill(Color.rgb(67,179,189));
            rectangle.setStroke(Color.DARKBLUE);

            Rectangle rectangle1 = new Rectangle(480,520);
            rectangle1.setFill(Color.WHITE);
            rectangle1.setStroke(Color.DARKBLUE);

            rectangle.xProperty().bind(gridPane.layoutXProperty());
            rectangle.xProperty().bind(gridPane.maxHeightProperty());

            successful.setFont(Font.font("Arial Black", FontWeight.BOLD,15));
            successful.setFill(Color.rgb(80,120,20));
            successful.setTextAlignment(TextAlignment.CENTER);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(rectangle);
            stackPane.getChildren().add(rectangle1);
            rectangle1.toBack();
            rectangle.toBack();
            stackPane.getChildren().add(gridPane);

            gridPane.setAlignment(Pos.CENTER);

            usernameErrorLabel.setTextFill(Color.RED);
            gridPane.add(usernameErrorLabel,0,2);

            passwordErrorLabel.setTextFill(Color.RED);
            gridPane.add(passwordErrorLabel,0,4);

            nameErrorLabel.setTextFill(Color.RED);
            gridPane.add(nameErrorLabel,0,6);

            surnameErrorLabel.setTextFill(Color.RED);
           gridPane.add(surnameErrorLabel,0,8);

            emailErrorLabel.setTextFill(Color.RED);
            gridPane.add(emailErrorLabel,0,10);

            birthdayErrorLabel.setTextFill(Color.RED);
            gridPane.add(birthdayErrorLabel,0,14);

            phonenoErrorLabel.setTextFill(Color.RED);
            gridPane.add(phonenoErrorLabel,0,12);

            salaryErrorLabel.setTextFill(Color.RED);
           gridPane.add(salaryErrorLabel,0,16);

            unsuccessfulText.setFont(Font.font("Arial Black",FontWeight.BOLD,15));
            unsuccessfulText.setTextAlignment(TextAlignment.CENTER);
            unsuccessfulText.setFill(Color.RED);

            Label usernameLabel = new Label("Username:");
            usernameLabel.setFont(Font.font("Arial Rounded MT Bold"));
            usernameLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(usernameLabel,0,1);

            Label passwordLabel = new Label("Password:");
            passwordLabel.setFont(Font.font("Arial Rounded MT Bold"));
            passwordLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(passwordLabel,0,3);

            Label firstNameLabel = new Label("First name:");
            firstNameLabel.setFont(Font.font("Arial Rounded MT Bold"));
            firstNameLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(firstNameLabel,0,5);

            Label lastNameLabel = new Label("Last name:");
            lastNameLabel.setFont(Font.font("Arial Rounded MT Bold"));
            lastNameLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(lastNameLabel,0,7);

            Label emailLabel = new Label("Email:");
            emailLabel.setFont(Font.font("Arial Rounded MT Bold"));
            emailLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(emailLabel,0,9);

            Label phoneNoLabel = new Label("Phone number:");
            phoneNoLabel.setFont(Font.font("Arial Rounded MT Bold"));
            phoneNoLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(phoneNoLabel,0,11);

            Label birthdayLabel = new Label("Birthday:");
            birthdayLabel.setFont(Font.font("Arial Rounded MT Bold"));
            birthdayLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(birthdayLabel,0,13);

            Label salaryLabel = new Label("Salary: ");
            salaryLabel.setFont(Font.font("Arial Rounded MT Bold"));
            salaryLabel.setTextFill(Color.rgb(9,17,91));
            gridPane.add(salaryLabel,0,15);


            gridPane.add(usernameTf,1,1);
            gridPane.add(passwordTf,1,3);
            gridPane.add(nameTf,1,5);
            gridPane.add(surnameTf,1,7);
            gridPane.add(emailTf,1,9);
            gridPane.add(phoneNoTf,1,11);
            gridPane.add(birthdayTf,1,13);
            gridPane.add(salaryTf,1,15);


            gridPane.add(salaryError,2,15);
            gridPane.add(usernameError,2,1);
            gridPane.add(passwordError,2,3);
            gridPane.add(nameError,2,5);
            gridPane.add(surnameError,2,7);
            gridPane.add(birthdayError,2,13);
            gridPane.add(emailError,2,9);
            gridPane.add(phoneError,2,11);


            passwordError.setVisible(false);
            usernameError.setVisible(false);
            salaryError.setVisible(false);
            nameError.setVisible(false);
            surnameError.setVisible(false);
            birthdayError.setVisible(false);
            emailError.setVisible(false);
            phoneError.setVisible(false);


            usernameErrorLabel.setVisible(false);
            passwordErrorLabel.setVisible(false);
            nameErrorLabel.setVisible(false);
            surnameErrorLabel.setVisible(false);
            emailErrorLabel.setVisible(false);
            birthdayErrorLabel.setVisible(false);
            phonenoErrorLabel.setVisible(false);
            salaryErrorLabel.setVisible(false);

            this.setPadding(new Insets(0,0,0,0));
           // gridPane.setPadding(new Insets(0,0,0,0));

            gridPane.add(signUpBt,1,17);
            signUpBt.setFont(Font.font("Comic Sans FB",FontWeight.BOLD,15));
            signUpBt.setTextFill(Color.DARKBLUE);
            signUpBt.setAlignment(Pos.BASELINE_RIGHT);


            Image image1 = new Image("file:go-back-2.png");
            administratorPageBt.setGraphic(new ImageView(image1));
            administratorPageBt.setPrefSize(10,10);
            administratorPageBt.setAlignment(Pos.TOP_LEFT);
            this.setTop(administratorPageBt);

            this.setCenter(stackPane);

            Scene scene = new Scene(this,1000,600);
            stage.setScene(scene);
            controller = new RegisterStaffController(person,this,choice);
        }


    public Stage getStage() {
        return stage;
    }

    public TextField getUsernameTf() {
        return usernameTf;
    }

    public PasswordField getPasswordTf() {
        return passwordTf;
    }

    public TextField getNameTf() {
        return nameTf;
    }

    public TextField getSurnameTf() {
        return surnameTf;
    }

    public TextField getEmailTf() {
        return emailTf;
    }

    public TextField getPhoneNoTf() {
        return phoneNoTf;
    }

    public TextField getBirthdayTf() {
        return birthdayTf;
    }

    public TextField getSalaryTf() {
        return salaryTf;
    }

    public Button getSignUpBt() {
        return signUpBt;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public Image getImage() {
        return image;
    }

    public Label getUsernameErrorLabel() {
        return usernameErrorLabel;
    }

    public Label getPasswordErrorLabel() {
        return passwordErrorLabel;
    }

    public Label getNameErrorLabel() {
        return nameErrorLabel;
    }

    public Label getSurnameErrorLabel() {
        return surnameErrorLabel;
    }

    public Label getEmailErrorLabel() {
        return emailErrorLabel;
    }

    public Label getBirthdayErrorLabel() {
        return birthdayErrorLabel;
    }

    public Label getPhonenoErrorLabel() {
        return phonenoErrorLabel;
    }

    public Label getSalaryErrorLabel() {
        return salaryErrorLabel;
    }

    public ImageView getSalaryError() {
        return salaryError;
    }

    public ImageView getUsernameError() {
        return usernameError;
    }

    public ImageView getPasswordError() {
        return passwordError;
    }

    public ImageView getNameError() {
        return nameError;
    }

    public ImageView getSurnameError() {
        return surnameError;
    }

    public ImageView getBirthdayError() {
        return birthdayError;
    }

    public ImageView getEmailError() {
        return emailError;
    }

    public ImageView getPhoneError() {
        return phoneError;
    }

    public Text getSuccesfulText() {
        return successful;
    }

    public Text getUnsuccessfulText() {
        return unsuccessfulText;
    }

    public static class ClickPane extends BorderPane{
            public ClickPane()
            {
                usernameTf.setId("usernameTf");
                passwordTf.setId("passwordTf");
                nameTf.setId("nameTf");
                surnameTf.setId("surnameTf");
                emailTf.setId("emailTf");
                phoneNoTf.setId("phoneNoTf");
                birthdayTf.setId("birthdayTf");
                salaryTf.setId("salaryTf");
                signUpBt.setId("signUpBt");
                usernameErrorLabel.setId("usernameErrorLabel");
                passwordErrorLabel.setId("passwordErrorLabel");
                nameErrorLabel.setId("nameErrorLabel");
                surnameErrorLabel.setId("surnameErrorLabel");
                emailErrorLabel.setId("emailErrorLabel");
                birthdayErrorLabel.setId("birthdayErrorLabel");
                phonenoErrorLabel.setId("phonenoErrorLabel");
                salaryErrorLabel.setId("salaryErrorLabel");
                salaryError.setId("salaryError");
                usernameError.setId("usernameError");
                passwordError.setId("passwordError");
                nameError.setId("nameError");
                surnameError.setId("surnameError");
                birthdayError.setId("birthdayError");
                emailError.setId("emailError");
                phoneError.setId("phoneError");
                successful.setId("successful");
                successful.getStyleClass().add("successful");
                unsuccessfulText.setId("unsuccessfulText");
                getChildren().addAll(usernameTf,passwordTf,nameTf,surnameTf,emailTf,phoneNoTf,
                        birthdayTf,salaryTf,signUpBt,usernameErrorLabel,passwordErrorLabel,
                        nameErrorLabel,surnameErrorLabel,emailErrorLabel,birthdayErrorLabel,
                        phonenoErrorLabel,salaryErrorLabel,salaryError,usernameError,nameError,
                        passwordError,surnameError,birthdayError,emailError,phoneError,successful,unsuccessfulText);
                System.out.println(lookup("#successful"));
            }
    }
}
