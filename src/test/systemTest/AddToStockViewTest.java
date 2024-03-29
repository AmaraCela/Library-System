package systemTest;

import Controllers.CategoryController;
import Controllers.RegisterStaffController;
import Views.AddToStockView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Book;
import models.Category;
import models.Manager;
import org.junit.jupiter.api.*;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AddToStockViewTest extends ApplicationTest {

    Button button;
    Button button1;
    Label unSuccessfulLabel;

    Label label2;
    TextField copiesTf;
    TableView tableView;
    Parent sceneRoot;

    static Category category;
    static Book book;
    static CategoryController categoryController;



    @Override
    public void start(Stage stage)
    {
        sceneRoot = new AddToStockView.ClickPane();
        Scene scene = new Scene(sceneRoot,500,500);
        stage.setScene(scene);
        stage.show();

        RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));

        new AddToStockView(new Manager("n","s","e","b","i","p",1,"1"),stage).getScene();
    }


    @BeforeAll
    public static void setUpAll()
    {
        category = new Category("Fiction","TestFiles//fictionBooks.dat");
        book = new Book("1","t1",category,"s1",10,15,15,"a1",1,"TestFiles//cost.txt");
        categoryController = new CategoryController();
        categoryController.addCategories(category);
        category.addBookToCategory(book);
    }


    @BeforeEach
    public void setUp()
    {
        button = lookup("#addBt").queryAs(Button.class);
        button1 = lookup("#pageBt").queryAs(Button.class);
        unSuccessfulLabel = lookup("#unSuccessfulLabel").queryAs(Label.class);
        copiesTf = lookup("#copiesTf").queryAs(TextField.class);
        tableView = lookup("#bookTableView").queryAs(TableView.class);
        label2 = lookup("#label2").queryAs(Label.class);
        tableView.getItems().clear();
        copiesTf.clear();
    }

    @AfterEach
    public void tearDown()
    {
        File file = new File("TestFiles//fictionBooks.dat");
        file.delete();
        file = new File("TestFiles//cost.txt");
        file.delete();
        file = new File("TestFiles//usernames.txt");
        file.delete();
        file = new File("TestFiles//employees.dat");
        file.delete();
        file = new File("cost.txt");
        file.delete();

        RegisterStaffController.readFromFile();

        tableView.getItems().clear();
    }

    @AfterAll
    static void returnOriginalFiles(){
        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        RegisterStaffController.readFromFile();

    }

    @Test
    void test_addValidAmountToStock(){
        tableView.getItems().clear();
        List<Book> books = List.of(book);
        tableView.getItems().add(book);
        System.out.println(tableView.getItems());
        tableView.getSelectionModel().select(0);
        clickOn(copiesTf).write("1");
        clickOn(button);
        assertFalse(unSuccessfulLabel.isVisible());
        assertEquals(2,((Book)tableView.getItems().get(0)).getStock());
    }

    @Test
    void test_addInvalidAmountToStock()
    {
        tableView.getItems().add(book);
        tableView.getSelectionModel().select(0);
        clickOn(copiesTf).write("-1");
        clickOn(button);
        assertTrue(unSuccessfulLabel.isVisible());
    }
}
