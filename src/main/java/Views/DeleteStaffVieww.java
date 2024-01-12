package Views;

import Controllers.DeleteStaffController;
import Controllers.RegisterStaffController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import models.Person;

import java.util.ArrayList;

public class DeleteStaffVieww extends BorderPane {

    private static final TableView<Person> tableView = new TableView<>();
    private Stage stage;
    private final TableColumn<Person,String> usernameColumn = new TableColumn<>("Username");
    private final TableColumn <Person,String> nameColumn = new TableColumn<>("First name");
    private final TableColumn<Person,String> surnameColumn = new TableColumn<>("Last name");
    private final TableColumn<Person,Double> salaryColumn = new TableColumn<>("Salary");
    private final TableColumn<Person,String> emailColumn = new TableColumn<>("Email");
    private final TableColumn<Person,String> phonenoColumn = new TableColumn<>("Phone number");
    private final TableColumn <Person,String>birthdayColumn = new TableColumn<>("Birthday");

    private static final Button administratorPageBt = new Button();
    private static final Button deleteBt = new Button("Delete");

    private int choice;
    public DeleteStaffVieww(Stage stage, int choice, Person person)
    {
        this.choice=choice;
        ArrayList <Person> accounts;

        ObservableList <Person> accountsObservable ;
        tableView.setMaxSize(550,200);

        Text text = new Text("Double click the record you want to edit");
        text.setFont(Font.font("Arial Black", FontWeight.LIGHT,12));
        text.setFill(Color.DARKBLUE);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.stage = stage;
        if(choice ==1)
        {
            tableView.setItems(FXCollections.observableList(RegisterStaffController.getLibrarians()));

        }
        else if (choice == 2)
        {
            tableView.setItems(FXCollections.observableList(RegisterStaffController.getManagers()));
        }




        usernameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Person, Double>("salary"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        phonenoColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNo"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("birthday"));
        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phonenoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        birthdayColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, salaryColumn, emailColumn, phonenoColumn, birthdayColumn);

        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        this.setTop(administratorPageBt);

        this.setCenter(tableView);
        deleteBt.setAlignment(Pos.CENTER);
        StackPane stackPane = new StackPane(deleteBt);
        stackPane.setPadding(new Insets(30));
        this.setBottom(stackPane);
        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);
        new DeleteStaffController(person, this);
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public Stage getStage() {
        return stage;
    }

    public TableView<Person> getTableView() {
        return tableView;
    }

    public Button getDeleteBt() {
        return deleteBt;
    }

    public int getChoice() {
        return choice;
    }

    public static class ClickPane extends BorderPane{

        public ClickPane(){
            administratorPageBt.setId("administratorPageBt");
            deleteBt.setId("deleteBt");
            tableView.setId("tableView");
            getChildren().addAll(administratorPageBt, deleteBt, tableView);
        }
    }

    public DeleteStaffVieww(){}
}
