package Views;

import Controllers.LogInController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInView extends BorderPane {
    private static TextField usernameTf = new TextField();
    private static PasswordField passwordTf = new PasswordField();
    private static Button logInBt = new Button("Log in");
    private GridPane gridPane = new GridPane();
    private Stage stage;
    public static Text loginSuccessful = new Text("You successfully logged in!");
    public static Text loginFailed = new Text("Wrong credentials");

    public LogInView (Stage stage)
    {
        usernameTf = new TextField();
        passwordTf = new PasswordField();
        this.stage = stage;
        StackPane stackPaneCenter = new StackPane();
        StackPane stackPaneBottom = new StackPane();

        stackPaneCenter.setPadding(new Insets(10,5,5,5));
        stackPaneBottom.setPadding(new Insets(5, 10, 30, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        Rectangle rectangle = new Rectangle(500,300);
        Rectangle rectangle1  = new Rectangle(490,320);
        rectangle1.setStroke(Color.DARKBLUE);
        rectangle1.setFill(Color.rgb(67,179,189));
        rectangle.setStroke(Color.DARKBLUE);
        rectangle.setFill(Color.WHITE);
        rectangle.xProperty().bind(this.widthProperty().divide(2));

        stackPaneCenter.getChildren().add(rectangle);
        rectangle.toBack();
        stackPaneCenter.getChildren().add(rectangle1);
        rectangle1.toBack();
        this.setCenter(stackPaneCenter);

        loginSuccessful.setVisible(false);
        loginFailed.setVisible(false);
        Label label1 = new Label("Username:");
        Label label2 = new Label("Password:");
        label1.setFont(Font.font("Arial Rounded MT Bold"));
        label2.setFont(Font.font("Arial Rounded MT Bold"));
        label1.setTextFill(Color.rgb(9,17,91));
        label2.setTextFill(Color.rgb(9,17,71));
        gridPane.add(label1, 1, 1);
        gridPane.add(label2, 1, 2);
        usernameTf.setAlignment(Pos.BASELINE_RIGHT);
        passwordTf.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(usernameTf, 2, 1);
        gridPane.add(passwordTf, 2, 2);

        stackPaneCenter.getChildren().add(gridPane);
        logInBt.setTextFill(Color.DARKBLUE);
        logInBt.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD,15));
        stackPaneBottom.getChildren().add(logInBt);
        this.setBottom(stackPaneBottom);
        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);
        new LogInController(this);
    }

    public TextField getUsernameTf() {
        return usernameTf;
    }

    public PasswordField getPasswordTf() {
        return passwordTf;
    }

    public Button getLogInBt() {
        return logInBt;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Stage getStage() {
        return stage;
    }

    public static class ClickPane extends BorderPane{

        public ClickPane(){
            loginSuccessful.setId("loginSuccessful");
            loginFailed.setId("loginFailed");
            logInBt.setId("logInBt");
            usernameTf.setId("usernameTf");
            passwordTf.setId("passwordTf");
            System.out.println(loginSuccessful.getId());
            getChildren().addAll(logInBt, usernameTf, passwordTf, loginSuccessful, loginFailed);
        }
    }
}

