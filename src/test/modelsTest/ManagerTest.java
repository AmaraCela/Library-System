package modelsTest;

import models.Manager;
import models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ManagerTest {

    Manager manager;
    @BeforeEach
    void setUp(){
        manager = new Manager("John","Doe","jdoe21@epoka.edu.al","22/02/2002","johndoe","john1234",345.5,"0678765432");
    }
    @Test
    void test_isDeleteBooksTrue(){
        manager.setDeleteBooks(true);
        Assertions.assertTrue(manager.isDeleteBooks());
    }

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    void test_isDeleteBooks(boolean boolVal){
        manager.setDeleteBooks(boolVal);
        Assertions.assertEquals(manager.isDeleteBooks(),boolVal);
    }
    @Test
    void test_isAddBooksFalse(){
        manager.setAddBooks(false);
        Assertions.assertFalse(manager.isAddBooks());
    }

    @Test
    void test_isAddToStockTrue(){
        manager.setAddToStock(true);
        Assertions.assertTrue(manager.isAddToStock());
    }

    @Test
    void test_isAddToStockFalse(){
        manager.setAddToStock(false);
        Assertions.assertFalse(manager.isAddToStock());
    }

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    void test_ManageCategories(boolean boolVal){
        manager.setManageCategories(boolVal);
        Assertions.assertEquals(manager.isManageCategories(),boolVal);
    }

    @Test
    void test_personnelData(){
        Assertions.assertEquals(manager.personnelData(),"Manager: John Doe Salary: 345.5");
    }
}
