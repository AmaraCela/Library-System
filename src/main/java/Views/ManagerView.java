package Views;

import Controllers.CategoryController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Book;
import models.Manager;

import java.io.File;
import java.util.ArrayList;

public class ManagerView extends BorderPane {

    private final Stage stage;
    private final MenuBar menuBar = new MenuBar();

    private final Menu categoriesMenu = new Menu("Categories");
    private final MenuItem manageCategoriesItem = new MenuItem("Manage categories");

    private final Menu booksMenu = new Menu("Books");
    private final MenuItem manageBooksItem = new MenuItem("Manage books");
    private final MenuItem supplyBooksItem = new MenuItem("Supply Books");
    private final MenuItem addToStockItem = new MenuItem("Add copies");
    private final Menu incomesMenu = new Menu("Incomes");
    private final MenuItem incomesItem = new MenuItem("Get incomes");
    private final Menu logOut = new Menu("Log out");
    private final MenuItem logOutItem = new MenuItem("Log out");



    public ManagerView(Stage stage)
    {
        this.stage = stage;
        categoriesMenu.getItems().addAll(manageCategoriesItem);
        booksMenu.getItems().addAll(supplyBooksItem,manageBooksItem,addToStockItem);
        incomesMenu.getItems().addAll(incomesItem);
        logOut.getItems().add(logOutItem);
        menuBar.getMenus().addAll(categoriesMenu,booksMenu,incomesMenu,logOut);

        this.setPadding(new Insets(0,10,20,0));
        menuBar.prefWidthProperty().bind(this.widthProperty());

        this.setTop(menuBar);
        Text label = new Text("Welcome to the manager page!\n\nNavigate the menus to perform tasks.");

        label.setTextAlignment(TextAlignment.CENTER);
        label.setFill(Color.DARKBLUE);
        label.setFont(Font.font("Arial Rounded MT Bold",20));
        label.setStroke(Color.LIGHTBLUE);


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(200,200);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(label,0,0);
        gridPane.setHgap(10);
        gridPane.setVgap(20);

        this.setCenter(gridPane);
        notifyLackOfStock(gridPane);

        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getCategoriesMenu() {
        return categoriesMenu;
    }

    public MenuItem getManageCategoriesItem() {
        return manageCategoriesItem;
    }

    public Menu getBooksMenu() {
        return booksMenu;
    }

    public MenuItem getManageBooksItem() {
        return manageBooksItem;
    }

    public MenuItem getSupplyBooksItem() {
        return supplyBooksItem;
    }

    public MenuItem getAddToStockItem() {
        return addToStockItem;
    }

    public Menu getLogOut() {
        return logOut;
    }

    public MenuItem getLogOutItem() {
        return logOutItem;
    }

    public Menu getIncomesMenu() {
        return incomesMenu;
    }

    public MenuItem getIncomesItem() {
        return incomesItem;
    }

    public void notifyLackOfStock( GridPane gridPane)
    {

        ArrayList <Book> books = new ArrayList<>();
        for(int i=0;i< CategoryController.getCategories().size();i++)
        {
            books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }


        int j = 1;
        for (int i = 0;i<books.size();i++)
        {
            if(books.get(i).getStock()<5)
            {

                j++;
                Text text = new Text("There are fewer than 5 copies of book with ISBN: "+books.get(i).getISBN()+".");
                text.setFont(Font.font("Arial Rounded MT Bold",12));
                text.setFill(Color.DARKRED);
                gridPane.add(text,0,j);

            }
        }

    }
}
