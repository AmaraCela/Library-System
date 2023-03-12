package Views;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LibrarianView extends BorderPane {

    private final Stage stage;
    private final MenuBar menuBar = new MenuBar();

    private final Menu books = new Menu("Books");
    private final Menu logOut = new Menu("Log out");

    private final MenuItem viewBooksItem = new MenuItem("View books");
    private final MenuItem logOutItem = new MenuItem("Log Out");

    public LibrarianView(Stage stage)
    {
        this.stage = stage;

        books.getItems().add(viewBooksItem);
        logOut.getItems().add(logOutItem);
        menuBar.getMenus().addAll(books,logOut);

        this.setTop(menuBar);
        menuBar.prefWidthProperty().bind(this.widthProperty());

        Text welcomeText = new Text("Welcome to the librarian page!\n\nNavigate the menus to perform tasks. ");
        welcomeText.setStroke(Color.LAVENDER);
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        welcomeText.setFill(Color.DARKBLUE);
        welcomeText.setFont(Font.font("Arial Rounded MT Bold",20));

        this.setCenter(welcomeText);
        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getBooks() {
        return books;
    }

    public MenuItem getViewBooksItem() {
        return viewBooksItem;
    }

    public Menu getLogOut() {
        return logOut;
    }

    public MenuItem getLogOutItem() {
        return logOutItem;
    }
}
