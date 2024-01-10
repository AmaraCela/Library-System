package Views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFx extends Application {
    @Override
    public void start(Stage stage) {
        View sceneRoot = new View();
        Scene scene = new Scene(sceneRoot);
        stage.setScene(scene);
        stage.show();
    }

    public static class View extends StackPane {
        public View() {
            Button button = new Button("Click me");
            getChildren().add(button);
            button.setOnAction(actionEvent -> button.setText("Clicked"));
        }
    }
}