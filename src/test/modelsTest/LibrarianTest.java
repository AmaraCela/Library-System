package modelsTest;

import models.Librarian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LibrarianTest {

    Librarian librarian;
    @BeforeEach
    void setUp(){
        librarian = new Librarian("Jessy", "Hamburg", "jhamburg21@epoka.edu.al","21/01/2001","jessyhamburg","jessy1234",310,"0697654124");
    }

    @ParameterizedTest
    @CsvSource({
            "2.5",
            "3"
    })
    void test_getPersonalRevenue(double total){
        librarian.setPersonalRevenue(total);
        Assertions.assertEquals(librarian.getPersonalRevenue(),total);
    }

    @Test
    void test_personnelData(){
        Assertions.assertEquals(librarian.personnelData(),"Librarian: Jessy Hamburg Salary: 310.0");
    }

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    void test_isCheckOutPermission(boolean boolVal){
        librarian.setCheckOutPermission(boolVal);
        Assertions.assertEquals(librarian.isCheckOutPermission(),boolVal);
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "56"
    })
    void test_getNumOfBooksSold(int numOfBooks){
        librarian.setNumOfBooksSold(numOfBooks);
        Assertions.assertEquals(librarian.getNumOfBooksSold(),numOfBooks);
    }

    @Test
    void test_getNumberOfBills(){
        librarian.setNumberOfBills();
        Assertions.assertEquals(librarian.getNumberOfBills(),1);
    }
}
