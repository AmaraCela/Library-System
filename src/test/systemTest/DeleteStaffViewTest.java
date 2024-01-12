package systemTest;

import Controllers.RegisterStaffController;
import Views.DeleteStaffVieww;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Librarian;
import models.Manager;
import models.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeleteStaffViewTest extends ApplicationTest {

    Parent sceneRoot;
    Button administratorPageBt;
    Button deleteBt;
    TableView<Person> tableView;
    public void start(Stage stage){
        sceneRoot = new DeleteStaffVieww.ClickPane();
        Scene scene = new Scene(sceneRoot, 500, 500);
        RegisterStaffController.setFile(new File("TestFiles/usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles/employees.dat"));
        stage.setScene(scene);
        new DeleteStaffVieww(stage, 2, new Manager("n","s","e","b","i","p",1,"1"));
        stage.show();
    }

    @BeforeEach
    void setUp(){
        new Manager("m","s","e","b","i","p",1,"1");
        new Librarian("l","s","e","b","i","p",1,"1");
        administratorPageBt = lookup("#administratorPageBt").queryAs(Button.class);
        deleteBt = lookup("#deleteBt").queryAs(Button.class);
        tableView = lookup("#tableView").queryTableView();
    }

    @AfterAll
    public static void tearDownAll()
    {
        File file = new File("TestFiles//fictionBooks.dat");
        file.delete();
        file = new File("TestFiles//cost.txt");
        file.delete();
        file = new File("TestFiles/usernames.txt");
        file.delete();
        file = new File("TestFiles/employees.dat");
        file.delete();
        file = new File("cost.txt");
        file.delete();
    }

    @Test
    void test_admBtnClicked(){
        clickOn(administratorPageBt);
        assertEquals(administratorPageBt.getText(), "");
    }

    @Test
    void test_deleteStaff(){
        ArrayList<Person> staff = new ArrayList<>();
        tableView.getSelectionModel().select(0);
        System.out.println(tableView.getSelectionModel().getSelectedItems());
        staff.addAll(tableView.getItems());
        System.out.println(staff);
        clickOn(deleteBt);
        ArrayList<Person> staffAfterDelete = new ArrayList<>();
        staffAfterDelete.addAll(tableView.getItems());
        System.out.println(staffAfterDelete.get(0).getName());
        assertNotEquals(staff, staffAfterDelete);
    }

}
