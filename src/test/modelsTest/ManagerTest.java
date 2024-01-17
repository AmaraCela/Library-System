package modelsTest;

import Controllers.RegisterStaffController;
import models.Manager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ManagerTest {

    Manager manager;
    @BeforeEach
    void setUp(){
        RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));

        manager = new Manager("John","Doe","jdoe21@epoka.edu.al","22/02/2002","johndoe","john1234",345.5,"0678765432");
    }

    @AfterAll
    public static void tearDown()
    {
        File file = new File("TestFiles//usernames.txt");
        file.delete();
        file = new File("TestFiles//employees.dat");
        file.delete();

        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        RegisterStaffController.readFromFile();

    }


    @Test
    void test_personnelData(){
        Assertions.assertEquals(manager.personnelData(),"Manager: John Doe Salary: 345.5");
    }
}
