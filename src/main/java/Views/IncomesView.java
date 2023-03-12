package Views;

import Controllers.RegisterStaffController;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Librarian;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class IncomesView extends BorderPane {

    private final Stage stage;
    private final TableView<Person> librariansTableView = new TableView<>();
    private final Button backBt = new Button();

    public IncomesView(Stage stage)
    {
        this.stage = stage;
        backBt.setGraphic(new ImageView("file:go-back-2.png"));
        backBt.setPrefSize(10,10);
        backBt.setAlignment(Pos.TOP_LEFT);

        this.setTop(backBt);

        TableColumn<Person,String> nameColumn = new TableColumn<>("First name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));

        TableColumn<Person,String> surnameColumn = new TableColumn<>("Last name");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("surname"));

        TableColumn<Person,Double> revenueColumn = new TableColumn<>("Revenue");
        revenueColumn.setCellValueFactory(new PropertyValueFactory<Person,Double>("personalRevenue"));

        TableColumn<Person,Integer> billsColumn = new TableColumn<>("Number of bills");
        billsColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("numberOfBills"));

        TableColumn<Person,Integer> booksColumn = new TableColumn<>("Books sold");
        booksColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("numOfBooksSold"));

        this.librariansTableView.getColumns().addAll(nameColumn,surnameColumn,revenueColumn,billsColumn,booksColumn);


        this.librariansTableView.getItems().addAll(FXCollections.observableList( RegisterStaffController.getLibrarians()));

        librariansTableView.setMaxSize(400,400);
        this.setCenter(librariansTableView);

        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);
    }


    public Stage getStage() {
        return stage;
    }

    public TableView<Person> getLibrariansTableView() {
        return librariansTableView;
    }

    public Button getBackBt() {
        return backBt;
    }
}
