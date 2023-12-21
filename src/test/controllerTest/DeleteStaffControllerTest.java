package controllerTest;

import Controllers.DeleteStaffController;
import mockFiles.MockLibrarian;
import models.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteStaffControllerTest {

    DeleteStaffController deleteStaffController = new DeleteStaffController();

    @Test
    void test_delete()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        List<Person> list = List.of(person);
        assertEquals(new ArrayList<Person>(),deleteStaffController.delete(list));
    }
}
