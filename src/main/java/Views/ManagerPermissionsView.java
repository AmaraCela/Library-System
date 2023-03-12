package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagerPermissionsView extends BorderPane {
    private final Stage stage;
    private final ComboBox<String> permissionsCB = new ComboBox<>();
    private final Text choosePermissionText = new Text("Choose the permission you want to modify: ");
    private final Button administratorPageBt = new Button();
    public ManagerPermissionsView(Stage stage)
    {
        this.stage= stage;

        choosePermissionText.setFont(Font.font("Arial Black,16"));
        choosePermissionText.setFill(Color.DARKBLUE);
        permissionsCB.getItems().addAll("Manage categories","Add books","Delete books","Add copies");

        GridPane gridPane = new GridPane();
        gridPane.add(choosePermissionText,0,0);
        gridPane.add(permissionsCB,1,0);

        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(20,20,20,20));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        this.setTop(administratorPageBt);
        this.setCenter(stackPane);
        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }

    public ComboBox<String> getPermissionsCB() {
        return permissionsCB;
    }

    public Text getChoosePermissionText() {
        return choosePermissionText;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }
}
