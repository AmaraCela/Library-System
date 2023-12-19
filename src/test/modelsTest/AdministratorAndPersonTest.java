package modelsTest;

import models.Administrator;
import models.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AdministratorAndPersonTest {

    Person administrator;
    @BeforeEach
    void setUp()
    {
        administrator = new Administrator("n","s","e","b","u","p",100,"pno");
    }

    @AfterEach
    void tearDown()
    {
        Person.setEmployeeCost(0);
    }
    @ParameterizedTest
    @CsvSource({
            "n",
            "n1",
    })
    void test_getName(String n)
    {
        administrator.setName(n);
        assertEquals(n, administrator.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "s",
            "s1",
    })
    void test_getSurname(String s)
    {
        administrator.setSurname(s);
        assertEquals(s, administrator.getSurname());
    }

    @ParameterizedTest
    @CsvSource({
            "e",
            "e1",
    })
    void test_getEmail(String e)
    {
        administrator.setEmail(e);
        assertEquals(e, administrator.getEmail());
    }

    @ParameterizedTest
    @CsvSource({
            "b",
            "b1",
    })
    void test_getBirthday(String b)
    {
        administrator.setBirthday(b);
        assertEquals(b, administrator.getBirthday());
    }


    @ParameterizedTest
    @CsvSource({
            "u",
            "u1",
    })
    void test_getUsername(String u)
    {
        administrator.setUsername(u);
        assertEquals(u, administrator.getUsername());
    }


    @ParameterizedTest
    @CsvSource({
            "p",
            "p1",
    })
    void test_getPassword(String p)
    {
        administrator.setPassword(p);
        assertEquals(p, administrator.getPassword());
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "110",
    })
    void test_getSalary(double s)
    {
        administrator.setSalary(s);
        assertEquals(s, administrator.getSalary());
    }

    @ParameterizedTest
    @CsvSource({
            "pno",
            "pno1",
    })
    void test_getPhoneNo(String pno)
    {
        administrator.setPhoneNo(pno);
        assertEquals(pno, administrator.getPhoneNo());
    }

    @Test
    void test_personnelData()
    {
        assertEquals("Administrator: n s Salary: 100.0", administrator.personnelData());
    }

    @Test
    void test_getEmployeeCost()
    {
        assertEquals(Person.getEmployeeCost(),100.0);
    }

    @Test
    void test_equals()
    {
        assertTrue(administrator.equals(new Administrator("n","s","e","b","u","p",100,"pno")));

    }

    @Test
    void test_differentName()
    {
        assertFalse(administrator.equals(new Administrator("n1","s","e","b","u","p",100,"pno")));
    }

    @Test
    void test_differentSurname()
    {
        assertFalse(administrator.equals(new Administrator("n","s1","e","b","u","p",100,"pno")));
    }

    @Test
    void test_differentEmail()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e1","b","u","p",100,"pno")));
    }

    @Test
    void test_differentBirthday()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e","b1","u","p",100,"pno")));
    }

    @Test
    void test_differentUsername()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e","b","u1","p",100,"pno")));
    }

    @Test
    void test_differentPassword()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e","b","u","p1",100,"pno")));
    }
    @Test
    void test_differentSalary()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e","b","u","p",101,"pno")));
    }
    @Test
    void test_differentPhoneNo()
    {
        assertFalse(administrator.equals(new Administrator("n","s","e","b","u","p",100,"pno1")));
    }


}
