package Views;

import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import models.Book;

import java.util.ArrayList;

public class CheckOutView extends BorderPane {

    private final Stage stage;
    private final ArrayList<TextField> textFields = new ArrayList<>();
    private final Button proceedBt = new Button("Proceed");
    private final ObservableList<Book> books;

    private final Button backBt = new Button();
    private final Label errorLabel = new Label("Re-check the quantities!");
    private final Label mustSelectLabel = new Label("Must select books to check out!");
    private final  Label label1 = new Label("Book title: ");
    private final Label label2 = new Label("Quantity: ");
    private final GridPane gridPane = new GridPane();


    public CheckOutView(Stage stage, ObservableList<Book> books)
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
            textFields.add(new TextField());
            textFields.get(i).setText("1");
            gridPane.add(textFields.get(i),1,i+1);
        }

        gridPane.add(proceedBt,0,i+2);

        errorLabel.setTextFill(Color.DARKRED);
        errorLabel.setFont(Font.font("Arial Bold",14));
        gridPane.add(errorLabel,1,i+2);
        errorLabel.setVisible(false);

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

    public ObservableList<Book> getBooks() {
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
}
