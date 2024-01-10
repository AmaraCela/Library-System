package viewTest;

import Views.DeleteStaffView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Librarian;
import models.Manager;
import models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeleteStaffViewTest extends ApplicationTest {

    Parent sceneRoot;
    Button administratorPageBt;
    Button deleteBt;
    TableView<Person> tableView;
    public void start(Stage stage){
        sceneRoot = new DeleteStaffView.ClickPane();
        Scene scene = new Scene(sceneRoot, 500, 500);
        stage.setScene(scene);
        new DeleteStaffView(stage, 2, new Manager("n","s","e","b","i","p",1,"1"));
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
