package Views;

import Controllers.CategoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SupplyBooksView extends BorderPane {

    private final Stage stage;
    private final Button administratorPageBt = new Button();
    private final Button addBt = new Button("Add");
    private final ComboBox<String> categoryCB = new ComboBox<>();
    private final TextField categoryTf = new TextField();
    private final Button addCategoryBt = new Button("Add Category");
    private final TextField ISBNTf = new TextField();
    private final TextField titleTf = new TextField();
    private final TextField supplierTf = new TextField();
    private final TextField purchasedPriceTf = new TextField();
    private final TextField originalPriceTf = new TextField();
    private final TextField sellingPriceTf = new TextField();
    private final TextField authorTf = new TextField();
    private final TextField stockTf = new TextField();
    private final Text textSuccessful = new Text("Book added successfully!");
    private final Text textISBN = new Text("The ISBN is already entered!");
    private final Text textTitle = new Text("The title can not have this length!");
    private final Text textSupplier = new Text("The supplier can not have this length!");
    private final Text textPrice = new Text("Check the price!");
    private final Text textOriginalPrice = new Text("Check the price!");
    private final Text textSellingPrice = new Text("Check the price!");
    private final Text textStock = new Text("Can not have a negative stock!");
    private final Text textCategory = new Text("Select the category!");
    private final Text textAuthor = new Text("Check the author!");

    private final Text textInvalidCategory = new Text("Enter a valid category!");
    private final Label label = new Label("Add new category");
    private final Label categoryLabel = new Label("Category: ");

    public SupplyBooksView(Stage stage)
    {
        this.stage = stage;
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Label("ISBN:"),0,0);
        gridPane.add(new Label("Title:"),0,2);
        gridPane.add(new Label("Supplier:"),0,4);
        gridPane.add(new Label("Purchased price:"),0,6);
        gridPane.add(new Label("Original price:"),0,8);
        gridPane.add(new Label("Selling price:"),0,10);
        gridPane.add(new Label("Author:"),0,12);
        gridPane.add(new Label("Stock:"),0,14);

        gridPane.add(categoryLabel,0,16);
        gridPane.add(categoryCB,1,16);


        gridPane.add(ISBNTf,1,0);
        gridPane.add(titleTf,1,2);
        gridPane.add(supplierTf,1,4);
        gridPane.add(purchasedPriceTf,1,6);
        gridPane.add(originalPriceTf,1,8);
        gridPane.add(sellingPriceTf,1,10);
        gridPane.add(authorTf,1,12);
        gridPane.add(stockTf,1,14);

        gridPane.setVgap(3);

        gridPane.add(addBt,0,18);
        gridPane.add(textSuccessful,1,18);

        StackPane stackPane = new StackPane();

        Rectangle rectangle = new Rectangle(500,500);
        rectangle.setFill(Color.rgb(67,179,189));
        rectangle.setStroke(Color.DARKBLUE);

        Rectangle rectangle1 = new Rectangle(480,520);
        rectangle1.setFill(Color.WHITE);
        rectangle1.setStroke(Color.DARKBLUE);

        stackPane.getChildren().addAll(rectangle,rectangle1,gridPane);
        rectangle1.toBack();
        rectangle.toBack();

        ArrayList<String> categories = CategoryController.getCategoryNames();
        gridPane.add(label, 0, 16);
        gridPane.add(categoryTf, 1, 16);
        gridPane.add(addCategoryBt, 0, 18);
        label.setVisible(false);
        categoryTf.setVisible(false);

        gridPane.add(textInvalidCategory,0,19);
        textInvalidCategory.setVisible(false);

        if(categories.size() == 0) {
            addBt.setVisible(false);
            label.setVisible(true);
            categoryTf.setVisible(true);
            categoryCB.setVisible(false);
            categoryLabel.setVisible(false);


        }

        else {
            ObservableList<String> observableList = FXCollections.observableList(categories);
            categoryCB.getItems().addAll(observableList);
            addBt.setVisible(true);
            label.setVisible(false);
            categoryTf.setVisible(false);
            addCategoryBt.setVisible(false);
            categoryCB.setVisible(true);
            categoryLabel.setVisible(true);

        }



        textSuccessful.setStroke(Color.DARKGREEN);

        textISBN.setStroke(Color.RED);

        textTitle.setStroke(Color.RED);

        textSupplier.setStroke(Color.RED);

        textPrice.setStroke(Color.RED);
        textOriginalPrice.setStroke(Color.RED);
        textSellingPrice.setStroke(Color.RED);
        textStock.setStroke(Color.RED);
        textAuthor.setStroke(Color.RED);
        textCategory.setStroke(Color.RED);

        textSuccessful.setVisible(false);
        textISBN.setVisible(false);
        textTitle.setVisible(false);
        textSupplier.setVisible(false);
        textPrice.setVisible(false);
        textStock.setVisible(false);
        textCategory.setVisible(false);
        textSellingPrice.setVisible(false);
        textOriginalPrice.setVisible(false);
        textAuthor.setVisible(false);

        gridPane.add(textISBN,0,1);
        gridPane.add(textTitle,0,3);
        gridPane.add(textSupplier,0,5);
        gridPane.add(textPrice,0,7);
        gridPane.add(textOriginalPrice,0,9);
        gridPane.add(textSellingPrice,0,11);
        gridPane.add(textAuthor,0,13);
        gridPane.add(new Label(""),0,17);
        //gridPane.add(textPrice,0,20);
        gridPane.add(textStock,0,15);
        gridPane.add(textCategory,0,19);

        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        this.setTop(administratorPageBt);
        this.setCenter(stackPane);

        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public Button getAddBt() {
        return addBt;
    }

    public ComboBox<String> getCategoryCB() {
        return categoryCB;
    }

    public TextField getCategoryTf() {
        return categoryTf;
    }

    public Button getAddCategoryBt() {
        return addCategoryBt;
    }

    public TextField getISBNTf() {
        return ISBNTf;
    }

    public TextField getTitleTf() {
        return titleTf;
    }

    public TextField getSupplierTf() {
        return supplierTf;
    }

    public TextField getPurchasedPriceTf() {
        return purchasedPriceTf;
    }

    public TextField getOriginalPriceTf() {
        return originalPriceTf;
    }

    public TextField getSellingPriceTf() {
        return sellingPriceTf;
    }

    public TextField getAuthorTf() {
        return authorTf;
    }

    public TextField getStockTf() {
        return stockTf;
    }

    public Text getTextSuccessful() {
        return textSuccessful;
    }

    public Text getTextISBN() {
        return textISBN;
    }

    public Text getTextTitle() {
        return textTitle;
    }

    public Text getTextSupplier() {
        return textSupplier;
    }

    public Text getTextPrice() {
        return textPrice;
    }

    public Text getTextStock() {
        return textStock;
    }

    public Text getTextCategory() {
        return textCategory;
    }

    public Label getLabel() {
        return label;
    }

    public Text getTextInvalidCategory() {
        return textInvalidCategory;
    }

    public Text getTextOriginalPrice() {
        return textOriginalPrice;
    }

    public Text getTextSellingPrice() {
        return textSellingPrice;
    }

    public Text getTextAuthor() {
        return textAuthor;
    }
}
