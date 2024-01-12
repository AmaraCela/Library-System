package Views;

import Controllers.RegisterStaffController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import models.Person;

import java.util.ArrayList;

public class ModifyStaffView extends BorderPane {

    private final TableView<Person> tableView = new TableView<>();
    private final int choice;
    private Stage stage;
    private final TableColumn<Person,String> usernameColumn = new TableColumn<>("Username");
    private final TableColumn <Person,String> nameColumn = new TableColumn<>("First name");
    private final TableColumn<Person,String> surnameColumn = new TableColumn<>("Last name");
    private final TableColumn<Person,Double> salaryColumn = new TableColumn<>("Salary");
    private final TableColumn<Person,String> emailColumn = new TableColumn<>("Email");
    private final TableColumn<Person,String> phonenoColumn = new TableColumn<>("Phone number");
    private final TableColumn <Person,String>birthdayColumn = new TableColumn<>("Birthday");

    private final Button administratorPageBt = new Button();

    private final Label usernameErrorLabel = new Label("Username not available!");

    private final Label passwordErrorLabel = new Label("Password must have at least 8 characters!");

    private final Label nameErrorLabel = new Label("Name can not have this length!");



    private final Label surnameErrorLabel = new Label("Last name can not have this length!");

    private final Label emailErrorLabel = new Label("Enter a valid email!");


    private final Label birthdayErrorLabel = new Label("Accepted birthday format is dd/mm/yyyy.");

    private final Label phonenoErrorLabel = new Label("Accepted number format is 06d dd dd ddd.");



    private final Label salaryErrorLabel = new Label("Enter a valid salary!");
    public ModifyStaffView (Stage stage,int choice)
    {
        this.choice = choice;
        ArrayList<Person> accounts = new ArrayList<>();
        Text text = new Text("Double click the record you want to edit.");
        text.setFont(Font.font("Arial Black", FontWeight.LIGHT,12));
        text.setFill(Color.DARKBLUE);

        ObservableList<Person> accountsObservable ;
        tableView.setMaxSize(550,200);
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);

        this.stage = stage;
        if(choice ==1)
        {
            accounts = RegisterStaffController.getLibrarians();

        }
        else if (choice == 2)
        {
            accounts = RegisterStaffController.getManagers();

        }

        accountsObservable = FXCollections.observableArrayList(accounts);
        tableView.getItems().addAll(accountsObservable);


        usernameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("username"));
        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        surnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        salaryColumn.setCellValueFactory(new PropertyValueFactory<Person, Double>("salary"));
        salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        emailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        phonenoColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNo"));
        phonenoColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("birthday"));
        birthdayColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, salaryColumn, emailColumn, phonenoColumn, birthdayColumn);

        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        this.setTop(administratorPageBt);
        this.setCenter(tableView);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5,20,40,20));
        gridPane.setVgap(10);
        gridPane.add(text,0,0);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(usernameErrorLabel,0,2);
        gridPane.add(passwordErrorLabel,0,3);
        gridPane.add(nameErrorLabel,0,4);
        gridPane.add(surnameErrorLabel,0,5);
        gridPane.add(emailErrorLabel,1,2);
        gridPane.add(birthdayErrorLabel,1,3);
        gridPane.add(phonenoErrorLabel,1,4);
        gridPane.add(salaryErrorLabel,1,5);

        usernameErrorLabel.setTextFill(Color.DARKRED);
        passwordErrorLabel.setTextFill(Color.DARKRED);
        nameErrorLabel.setTextFill(Color.DARKRED);
        surnameErrorLabel.setTextFill(Color.DARKRED);
        emailErrorLabel.setTextFill(Color.DARKRED);
        birthdayErrorLabel.setTextFill(Color.DARKRED);
        phonenoErrorLabel.setTextFill(Color.DARKRED);
        salaryErrorLabel.setTextFill(Color.DARKRED);


        usernameErrorLabel.setVisible(false);
        passwordErrorLabel.setVisible(false);
        nameErrorLabel.setVisible(false);
        surnameErrorLabel.setVisible(false);
        emailErrorLabel.setVisible(false);
        birthdayErrorLabel.setVisible(false);
        phonenoErrorLabel.setVisible(false);
        salaryErrorLabel.setVisible(false);

        this.setBottom(gridPane);
        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);


    }

    public TableView<Person> getTableView() {
        return tableView;
    }

    public Stage getStage() {
        return stage;
    }

    public TableColumn<Person, String> getUsernameColumn() {
        return usernameColumn;
    }

    public TableColumn<Person, String> getNameColumn() {
        return nameColumn;
    }

    public TableColumn<Person, String> getSurnameColumn() {
        return surnameColumn;
    }

    public TableColumn<Person, Double> getSalaryColumn() {
        return salaryColumn;
    }

    public TableColumn<Person, String> getEmailColumn() {
        return emailColumn;
    }

    public TableColumn<Person, String> getPhonenoColumn() {
        return phonenoColumn;
    }

    public TableColumn<Person, String> getBirthdayColumn() {
        return birthdayColumn;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
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

    public int getChoice() {
        return choice;
    }
}
