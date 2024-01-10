package Views;

import Controllers.AddToStockController;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Book;
import models.Person;

import java.util.ArrayList;

public class AddToStockView extends BorderPane {
    private final Stage stage;
    private static final TableView<Book> bookTableView = new TableView<>();
    private final TableColumn<Book,String> isbnColumn = new TableColumn<>("ISBN");
    private final TableColumn<Book,String> titleColumn = new TableColumn<>("Title");
    private final TableColumn<Book,Integer> stockColumn = new TableColumn<>("Stock");

    private final ArrayList<Book> books;

    public static Button pageBt= new Button();
    private static final TextField copiesTf = new TextField();
    public static Button addBt = new Button("Add");

    private static final Label unSuccessfulLabel = new Label("Re-check the number!");
    private static final Label label2 = new Label("You must select a book first!");
    private static AddToStockController addToStockController;


    public AddToStockView(Person person, Stage stage)
    {
        this.stage = stage;
        books = new ArrayList<>();
        for (int i = 0; i< CategoryController.getCategories().size(); i++)
        {
            books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }
        bookTableView.getColumns().addAll(isbnColumn,titleColumn,stockColumn);
        bookTableView.getItems().addAll(FXCollections.observableList(books));
        bookTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        bookTableView.setMaxSize(500,400);
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("stock"));

        pageBt.setGraphic(new ImageView("file:go-back-2.png"));
        pageBt.setPrefSize(10,10);
        pageBt.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);
        this.setTop(pageBt);
        this.setCenter(bookTableView);

        this.setPadding(new Insets(0));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(30);
        gridPane.setHgap(20);
        Label label1 = new Label("Select the book you will add copies to:");
        Label label = new Label("Enter the number of copies ");
        label.setFont(Font.font("Arial Rounded MT Bold",12));
        label.setTextFill(Color.DARKBLUE);

        label1.setFont(Font.font("Arial Rounded MT Bold",14));
        label1.setTextFill(Color.DARKBLUE);

        label2.setFont(Font.font("Arial",12));
        label.setTextFill(Color.DARKRED);
        gridPane.add(label1,0,0);
        gridPane.add(label,0,1);
        gridPane.add(copiesTf,1,1);
        gridPane.add(addBt,1,2);
        gridPane.add(label2,1,3);
        unSuccessfulLabel.setTextFill(Color.DARKRED);
        unSuccessfulLabel.setVisible(false);
        unSuccessfulLabel.setFont(Font.font("Arial Rounded MT Bold",12));
        label2.setVisible(false);

        gridPane.add(unSuccessfulLabel,1,3);

        this.setBottom(gridPane);
        addToStockController = new AddToStockController(person, this);
    }

    public Stage getStage() {
        return stage;
    }

    public TableView<Book> getBookTableView() {
        return bookTableView;
    }

    public TableColumn<Book, String> getIsbnColumn() {
        return isbnColumn;
    }

    public TableColumn<Book, String> getTitleColumn() {
        return titleColumn;
    }

    public TableColumn<Book, Integer> getStockColumn() {
        return stockColumn;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Button getPageBt() {
        return pageBt;
    }

    public TextField getCopiesTf() {
        return copiesTf;
    }

    public Button getAddBt() {
        return addBt;
    }

    public Label getUnSuccessfulLabel() {
        return unSuccessfulLabel;
    }

    public Label getLabel2() {
        return label2;
    }



    public static class ClickPane extends BorderPane {
        public ClickPane(){

            System.out.println(unSuccessfulLabel.isVisible()+"here");
            addBt.setId("addBt");
            pageBt.setId("pageBt");
//            addBt.setOnAction(actionEvent -> addBt.setText("Clicked"));
//            pageBt.setOnAction(actionEvent -> pageBt.setText("Clicked"));
            unSuccessfulLabel.setId("unSuccessfulLabel");
            label2.setId("label2");
            copiesTf.setId("copiesTf");
            unSuccessfulLabel.setVisible(false);
            bookTableView.setId("bookTableView");
            getChildren().addAll(addBt, pageBt, unSuccessfulLabel, label2, copiesTf, bookTableView);
        }
        public static AddToStockController getAddToStockController() {
            return addToStockController;
        }
    }
}
