package Views;

import Controllers.CategoryController;
import Controllers.ManageBooksController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Book;
import models.Person;

import java.util.ArrayList;

public class ManageBooksView extends BorderPane {

    private Stage stage;
    private static final Button filterByCategoryBt = new Button("Filter by category");
    private final Button administratorPageBt = new Button();
    private final Button librarianPageBt = new Button();

    private final Button managerPageBt = new Button();
    private static final TableView <Book> tableView = new TableView<>();
    private final TableColumn<Book,String> isbnColumn = new TableColumn<>("ISBN");
    private final TableColumn<Book,String> titleColumn = new TableColumn<>("Title");
    private final TableColumn<Book,String> supplierColumn = new TableColumn<>("Supplier");
    private final TableColumn<Book,Double> purchasedPriceColumn = new TableColumn<>("Purchased price");
    private final TableColumn<Book,Double> originalPriceColumn  = new TableColumn<>("Original price");
    private final TableColumn<Book,Double> sellingPriceColumn = new TableColumn<>("SellingPrice");
    private final TableColumn<Book,String> authorColumn = new TableColumn<>("Author");
    private final TableColumn<Book, Integer> stockColumn = new TableColumn<>("Stock");
    private final GridPane gridPane = new GridPane();
    private static final Button deleteBt = new Button("Delete books");
    private static final Button checkOutBt = new Button("Check out");
    private static final Button selectBt = new Button("Select");
    private final ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    private  ArrayList<Book> books;
    public ManageBooksView(Person person, Stage stage, int choice)
    {
        this.books = new ArrayList<>();
        this.stage = stage;
        deleteBt.setVisible(false);
        checkOutBt.setVisible(false);

        for (int i = 0; i< CategoryController.getCategories().size(); i++)
        {
            this.books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }
        System.out.println("the size of books is"+this.books.size());
        tableView.setEditable(false);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));


        titleColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));

        supplierColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("supplier"));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        purchasedPriceColumn.setCellValueFactory(new PropertyValueFactory<Book,Double>("purchasedPrice"));


        originalPriceColumn.setCellValueFactory(new PropertyValueFactory<Book,Double>("originalPrice"));


        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Book,Double>("sellingPrice"));


        authorColumn.setCellValueFactory(new PropertyValueFactory<Book,String >("author"));


        stockColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("stock"));


        this.tableView.getColumns().addAll(isbnColumn,titleColumn,supplierColumn,stockColumn,authorColumn,purchasedPriceColumn,originalPriceColumn,sellingPriceColumn);
        this.tableView.getItems().addAll(FXCollections.observableList(books));



        tableView.setMaxSize(400,400);
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPadding(new Insets(5));
        stackPane.getChildren().add(tableView);
        this.setBottom(stackPane);
        this.setPadding(new Insets(0,30,30,0));

        ArrayList<String> categoryNames = CategoryController.getCategoryNames();
        for (int i = 0;i<categoryNames.size();i++)
        {
            checkBoxes.add(new CheckBox(categoryNames.get(i)));
            gridPane.add(checkBoxes.get(i),0,i);

        }
        gridPane.add(filterByCategoryBt,0,7);
        gridPane.add(deleteBt,7,7);
        gridPane.add(checkOutBt,3,7);
        gridPane.add(selectBt,0,8);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0;i<checkBoxes.size();i++)
        {
            checkBoxes.get(i).setVisible(false);
        }
        selectBt.setVisible(false);
        this.setCenter(gridPane);

        if(choice==1)
        {
            this.setTop(librarianPageBt);
        }
        if(choice==2)
        {
            this.setTop(managerPageBt);
        }
        else if(choice ==3)
        {
            this.setTop(administratorPageBt);
        }
        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);

        librarianPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        librarianPageBt.setPrefSize(10,10);
        librarianPageBt.setAlignment(Pos.TOP_LEFT);

        managerPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        managerPageBt.setPrefSize(10,10);
        managerPageBt.setAlignment(Pos.TOP_LEFT);


        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

        new ManageBooksController(person,this);

    }


    public Stage getStage() {
        return stage;
    }

    public Button getFilterByCategoryBt() {
        return filterByCategoryBt;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public TableView<Book> getTableView() {
        return tableView;
    }

    public TableColumn<Book, String> getIsbnColumn() {
        return isbnColumn;
    }

    public TableColumn<Book, String> getTitleColumn() {
        return titleColumn;
    }

    public TableColumn<Book, String> getSupplierColumn() {
        return supplierColumn;
    }

    public TableColumn<Book, Double> getPurchasedPriceColumn() {
        return purchasedPriceColumn;
    }

    public TableColumn<Book, Double> getOriginalPriceColumn() {
        return originalPriceColumn;
    }

    public TableColumn<Book, Double> getSellingPriceColumn() {
        return sellingPriceColumn;
    }

    public TableColumn<Book, String> getAuthorColumn() {
        return authorColumn;
    }

    public TableColumn<Book, Integer> getStockColumn() {
        return stockColumn;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Button getDeleteBt() {
        return deleteBt;
    }

    public ArrayList<CheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    public Button getCheckOutBt() {
        return checkOutBt;
    }

    public Button getSelectBt() {
        return selectBt;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void updateBooks()
    {
        this.books.clear();
//        new CategoryController().updateCategories();
        CategoryController.updateCategories();

        for (int i = 0; i< CategoryController.getCategories().size(); i++)
        {
            this.books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }
    }

    public Button getLibrarianPageBt() {
        return librarianPageBt;
    }

    public Button getManagerPageBt() {
        return managerPageBt;
    }

    public static class ClickPane extends BorderPane{
        public ClickPane()
        {
            filterByCategoryBt.setId("filterByCategoryBt");
            tableView.setId("tableView");
            deleteBt.setId("deleteBt");
            selectBt.setId("selectBt");
            checkOutBt.setId("checkOutBt");
            getChildren().addAll(filterByCategoryBt,tableView,deleteBt,selectBt,checkOutBt);
        }
    }

}
