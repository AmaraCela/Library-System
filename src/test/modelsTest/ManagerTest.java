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

    @Test
    void test_isDeleteBooksFalse(){
        manager.setDeleteBooks(false);
        Assertions.assertFalse(manager.isDeleteBooks());
    }

    @Test
    void test_isAddBooksTrue(){
        manager.setAddBooks(true);
        Assertions.assertTrue(manager.isAddBooks());
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
            "true, true",
            "false, false"
    })
    void test_ManageCategories(boolean manageCategories, boolean result){
        manager.setManageCategories(manageCategories);
        Assertions.assertEquals(manageCategories,result);
    }

    @Test
    void test_isManageCategories(){
        manager.setManageCategories(true);
        Assertions.assertTrue(manager.isManageCategories());
    }

    @Test
    void test_personnelData(){
        Assertions.assertEquals(manager.personnelData(),"Manager: John Doe Salary: 345.5");
    }
}
