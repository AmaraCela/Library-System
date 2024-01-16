package IntegrationTest;

import Controllers.DeleteStaffController;
import models.Librarian;
import models.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteStaffControllerIntegrationTest {
    DeleteStaffController deleteStaffController = new DeleteStaffController();
    @AfterAll
    public static void tearDown()
    {
        File file = new File("employees.dat");
        file.delete();
        file = new File("usernames.txt");
        file.delete();
    }

    @Test
    void test_delete()
    {
        Person person = new Librarian("n","s","e","b","u","p",1,"pno");
        List<Person> list = List.of(person);
        ArrayList<Person> d = deleteStaffController.delete(list);
        assertEquals(new ArrayList<Person>(),d);
    }
}
