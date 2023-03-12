package Views;

import Controllers.CategoryController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import models.Category;

import java.util.ArrayList;

public class AddCategoryView extends BorderPane {

    private Stage stage;
    private final TableView<Category> categoryTableView = new TableView<>();
    private final TableColumn<Category,String> categoryNameColumn = new TableColumn<>("Category Name");

    private final Button addBt = new Button("Add");
    private final TextField categoryTf = new TextField();
    private final Label successfulLabel = new Label("Category added successfully!");
    private final Label unsuccessfulLabel = new Label("Category not valid!");

    private final Button administratorPageBt = new Button();
    private final Button deleteBt = new Button("Delete");


    public AddCategoryView(Stage stage)
    {
        this.stage = stage;
        this.setPadding(new Insets(0,0,20,0));
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,0,0,0));
        gridPane.setVgap(5);

        gridPane.setHgap(7);

        categoryTableView.getColumns().add(categoryNameColumn);
        ArrayList <Category> categories = CategoryController.getCategories();

        categoryTableView.getItems().addAll(FXCollections.observableArrayList(categories));
        categoryTableView.setMaxSize(200,200);

        categoryTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        categoryNameColumn.setMaxWidth(200);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(categoryTableView);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(addBt,1,1);
        gridPane.add(categoryTf,1,0);
        Label label = new Label("Add category: ");
        label.setFont(Font.font("Arial Rounded MT Bold"));
        label.setTextFill(Color.DARKBLUE);
        Label deleteLabel = new Label("Or delete category by selecting the category and pressing delete:");
        deleteLabel.setFont(Font.font("Arial Rounded MT Bold"));
        deleteLabel.setTextFill(Color.DARKBLUE);
        gridPane.add(label,0,0);
        gridPane.setAlignment(Pos.CENTER);
        successfulLabel.setFont(Font.font("Arial Rounded MT Bold", FontWeight.LIGHT,12));
        successfulLabel.setTextFill(Color.DARKGREEN);
        unsuccessfulLabel.setFont(Font.font("Arial Rounded MT Bold", FontWeight.LIGHT,12));
        unsuccessfulLabel.setTextFill(Color.DARKRED);
        gridPane.add(successfulLabel,1,2);
        gridPane.add(unsuccessfulLabel,0,2);
        gridPane.add(deleteLabel,0,3);
        gridPane.add(deleteBt,1,3);
        unsuccessfulLabel.setVisible(false);
        successfulLabel.setVisible(false);

        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        this.setTop(administratorPageBt);
        this.setCenter(gridPane);

        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<Category,String>("categoryName"));

        this.setBottom(stackPane);


        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public TableView<Category> getCategoryTableView() {
        return categoryTableView;
    }

    public TableColumn<Category, String> getCategoryNameColumn() {
        return categoryNameColumn;
    }

    public Button getAddBt() {
        return addBt;
    }

    public TextField getCategoryTf() {
        return categoryTf;
    }

    public Label getSuccessfulLabel() {
        return successfulLabel;
    }

    public Label getUnsuccessfulLabel() {
        return unsuccessfulLabel;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public Button getDeleteBt() {
        return deleteBt;
    }
}
