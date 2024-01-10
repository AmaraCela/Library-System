package Views;

import Controllers.CheckOutController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Book;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class CheckOutView extends BorderPane {

    private final Stage stage;
    private final ArrayList<TextField> textFields = new ArrayList<>();
    private static final Button proceedBt = new Button("Proceed");
    private final List<Book> books;
    private final Button backBt = new Button();
    private static final Label errorLabel = new Label("Re-check the quantities!");
    private static final Label mustSelectLabel = new Label("Must select books to check out!");
    private final  Label label1 = new Label("Book title: ");
    private final Label label2 = new Label("Quantity: ");
    private final GridPane gridPane = new GridPane();
    private static TextField quantityTf = new TextField();
    private CheckOutController controller;
    private static Text success = new Text();


    public CheckOutView(Person person, Stage stage, List<Book> books)
    {
        this.books = books;

        this.setPadding(new Insets(30));

        gridPane.setMinSize(200,200);
        gridPane.setAlignment(Pos.CENTER);

        label1.setFont(Font.font("Arial Rounded MT Bold",14));
        label1.setTextFill(Color.DARKBLUE);
        label1.setVisible(false);
        gridPane.add(label1,0,0);


        label2.setFont(Font.font("Arial Rounded MT Bold",14));
        label2.setTextFill(Color.DARKBLUE);
        label2.setVisible(false);
        gridPane.add(label2,1,0);
        gridPane.setVgap(10);
        gridPane.setHgap(30);
        int i;
        for(i = 0;i<this.books.size();i++)
        {
            gridPane.add(new Label(this.books.get(i).getTitle()),0,i+1);
            quantityTf = new TextField();
            quantityTf.setId("quantityTf");
            textFields.add(quantityTf);
            quantityTf.setText("1");
            gridPane.add(quantityTf,1,i+1);
        }

        gridPane.add(proceedBt,0,i+2);

        errorLabel.setTextFill(Color.DARKRED);
        errorLabel.setFont(Font.font("Arial Bold",14));
        gridPane.add(errorLabel,1,i+2);
        errorLabel.setVisible(false);

        success.setFont(Font.font("Arial Rounded MT Bold",12));
        success.setFill(Color.DARKBLUE);

        gridPane.add(success,4,4);
        mustSelectLabel.setTextFill(Color.DARKRED);
        mustSelectLabel.setFont(Font.font("Arial Bold",14));
        gridPane.add(mustSelectLabel,1,i+2);
        mustSelectLabel.setVisible(false);

        backBt.setGraphic(new ImageView("file:go-back-2.png"));
        backBt.setPrefSize(10,10);
        backBt.setAlignment(Pos.TOP_LEFT);
        proceedBt.setVisible(false);

        this.setCenter(gridPane);

        this.setTop(backBt);


        Scene scene = new Scene(this,1000,600);


        this.stage = stage;
        stage.setScene(scene);
        controller = new CheckOutController(person,this,books);

    }

    public Stage getStage() {
        return stage;
    }

    public ArrayList<TextField> getTextFields() {
        return textFields;
    }



    public Button getProceedBt() {
        return proceedBt;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Button getBackBt() {
        return backBt;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public Label getMustSelectLabel() {
        return mustSelectLabel;
    }

    public Label getLabel1() {
        return label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Text getSuccess() {
        return success;
    }

    public void setSuccess(Text success) {
        this.success = success;
    }

    public static class ClickPane extends BorderPane{
        public ClickPane()
        {
            proceedBt.setId("proceedBt");
            errorLabel.setId("errorLabel");
            success.setId("success");
            getChildren().addAll(proceedBt,errorLabel, quantityTf, success);
        }
    }
}
