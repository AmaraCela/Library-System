package modelsTest;

import models.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Manager manager;
    @BeforeEach
    void setUp(){
        manager = new Manager("John","Doe","jdoe21@epoka.edu.al","22/02/2002","johndoe","john1234",345.5,"0678765432");
    }


    @Test
    void test_personnelData(){
        Assertions.assertEquals(manager.personnelData(),"Manager: John Doe Salary: 345.5");
    }
}
