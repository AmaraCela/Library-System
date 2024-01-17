package IntegrationTest;

import Controllers.DeleteStaffController;
import Controllers.RegisterStaffController;
import models.Librarian;
import models.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteStaffControllerIntegrationTest {
    DeleteStaffController deleteStaffController = new DeleteStaffController();
    @AfterAll
    public static void tearDown()
    {
        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        RegisterStaffController.readFromFile();
    }

    @AfterEach
    void delete(){
        File file = new File("TestFiles//employees.dat");
        file.delete();
        file = new File("TestFiles//usernames.txt");
        file.delete();

        RegisterStaffController.readFromFile();
    }
    @BeforeEach
    public void setUp()
    {
        RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));
    }
    @Test
    void test_delete()
    {
        Person person = new Librarian("n","s","e","b","u","p",1,"pno");
        List<Person> list = List.of(person);
        ArrayList<Person> d = deleteStaffController.delete(list);
        assertEquals(RegisterStaffController.getAccounts(), d);
    }
}
