package modelsTest;

import Controllers.RegisterStaffController;
import models.Librarian;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;

public class LibrarianTest {

    Librarian librarian;
    @BeforeEach
    void setUp(){
        RegisterStaffController.setFile(new File("TestFiles/usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles/employees.dat"));
        librarian = new Librarian("Jessy", "Hamburg", "jhamburg21@epoka.edu.al","21/01/2001","jessyhamburg","jessy1234",310,"0697654124");
    }
    @AfterAll
    public static void tearDown()
    {
        File file = new File("TestFiles/usernames.txt");
        file.delete();
        file = new File("TestFiles/employees.dat");
        file.delete();
    }

    @ParameterizedTest
    @CsvSource({
            "2.5",
            "1",
            "0"
    })
    void test_getPersonalRevenueValid(double personalRevenue){
        Assertions.assertTrue(personalRevenue >= 0);
        librarian.setPersonalRevenue(personalRevenue);
        Assertions.assertEquals(librarian.getPersonalRevenue(),personalRevenue);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "-13"
    })
    void test_getPersonalRevenueInvalid(double personalRevenue){
        Assertions.assertTrue(personalRevenue < 0);
        librarian.setPersonalRevenue(personalRevenue);
        Assertions.assertEquals(librarian.getPersonalRevenue(), personalRevenue);
    }

    @Test
    void test_personnelData(){
        Assertions.assertEquals(librarian.personnelData(),"Librarian: Jessy Hamburg Salary: 310.0");
    }


    @ParameterizedTest
    @CsvSource({
            "0",
            "100",
            "56"
    })
    void test_getValidNumOfBooksSold(int numOfBooks){
        Assertions.assertTrue(numOfBooks >= 0);
        librarian.setNumOfBooksSold(numOfBooks);
        Assertions.assertEquals(librarian.getNumOfBooksSold(),numOfBooks);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "-2"
    })
    void test_getInvalidNumOfBooksSold(int numOfBooks){
        Assertions.assertTrue(numOfBooks < 0);
        librarian.setNumOfBooksSold(numOfBooks);
        Assertions.assertEquals(librarian.getNumOfBooksSold(),numOfBooks);
    }
    @Test
    void test_getNumberOfBills(){
        librarian.setNumberOfBills(1);
        Assertions.assertEquals(librarian.getNumberOfBills(),1);
    }
}
