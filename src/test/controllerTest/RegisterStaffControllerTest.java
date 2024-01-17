package controllerTest;

import Auxilaries.IllegalSalaryException;
import Controllers.RegisterStaffController;
import mockFiles.MockLibrarian;
import models.Administrator;
import models.Librarian;
import models.Manager;
import models.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterStaffControllerTest {

    RegisterStaffController registerStaffController;
    @BeforeEach
    void setUp()
    {
        RegisterStaffController.setFile(new File("TestFiles//usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("TestFiles//employees.dat"));

        registerStaffController = new RegisterStaffController(new File("TestFiles//personnel.dat"),new File("TestFiles//usernames.txt"),1);
    }
    @AfterEach
    void tearDown()
    {
        File file = new File("TestFiles//personnel.dat");
        file.delete();
        file = new File("TestFiles//employees.dat");
        file.delete();
        file = new File("TestFiles//usernames.txt");
        file.delete();

        RegisterStaffController.readFromFile();
    }

    @AfterAll
    static void returnOriginalFiles(){
        RegisterStaffController.setFile(new File("usernames.txt"));
        RegisterStaffController.setBinaryFile(new File("employees.dat"));

        RegisterStaffController.readFromFile();

    }


    //equivalence class testing
    @Test
    void test_validateUsernameEmptyString()
    {
        assertFalse(RegisterStaffController.validateUsername(""));
    }

    @Test
    void test_validateUsernameAlreadyPresent()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertFalse(RegisterStaffController.validateUsername("u"));
    }
    @Test
    void test_validateUsernameNotPresent()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertTrue(RegisterStaffController.validateUsername("amara"));
    }

    @Test
    void test_validateUsernameNull()
    {
        assertFalse(RegisterStaffController.validateUsername(null));
    }


    @Test
    void test_validatePasswordNull()
    {
        assertFalse(RegisterStaffController.validatePassword(null));
    }

    @Test
    void test_validatePasswordShort()
    {
        assertFalse(RegisterStaffController.validatePassword("a"));
    }

    @Test
    void test_validatePasswordLongEnough()
    {
        assertTrue(RegisterStaffController.validatePassword("12345678"));
        assertTrue(RegisterStaffController.validatePassword("123456789"));
    }


    // equivalence and boundary value testing = edge testing

    @ParameterizedTest
    @CsvSource({
            "a",
            "aaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    })
    void test_validateNameAcceptableLength(String name)
    {
        assertTrue(RegisterStaffController.validateName(name));
    }

    @Test
    void test_validateNameInvalid()
    {
        assertFalse(RegisterStaffController.validateName(""));
        assertFalse(RegisterStaffController.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @ParameterizedTest
    @CsvSource({
            "a",
            "aaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    })
    void test_validateSurnameAcceptableLength(String surname)
    {
        assertTrue(RegisterStaffController.validateSurname(surname));
    }

    @Test
    void test_validateSurnameInvalid()
    {
        assertFalse(RegisterStaffController.validateSurname(""));
        assertFalse(RegisterStaffController.validateSurname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    //equivalence class testing
    @Test
    void test_validateEmailValid()
    {
        assertTrue(RegisterStaffController.validateEmail("a@a.com"));
    }

    @Test
    void test_validateEmailInvalid()
    {
        assertFalse(RegisterStaffController.validateEmail("@gmail.com"));
        assertFalse(RegisterStaffController.validateEmail("a.com"));
        assertFalse(RegisterStaffController.validateEmail("a@.com"));
        assertFalse(RegisterStaffController.validateEmail("a@gmail.co"));
        assertFalse(RegisterStaffController.validateEmail(""));
    }


    @Test
    void test_validateBirthdayValid()
    {
        assertTrue(RegisterStaffController.validateBirthday("01 01 1900"));
    }

    @Test
    void test_validateBirthdayInvalid()
    {
        assertFalse(RegisterStaffController.validateBirthday("1 1 1"));
        assertFalse(RegisterStaffController.validateBirthday("111 111 1"));
    }

    @Test
    void test_validatePhoneNoValid()
    {
        assertTrue(RegisterStaffController.validatePhoneNo("066 66 66 666"));
        assertTrue(RegisterStaffController.validatePhoneNo("067 77 77 777"));
    }

    @ParameterizedTest
    @CsvSource({
            "0677777777",
            "057 77 77 777",
            "06 77 777 77",
    })
    void test_validatePhoneNoInvalid(String no)
    {
        assertFalse(RegisterStaffController.validatePhoneNo(no));
    }

    @ParameterizedTest
    @CsvSource({
            "101",
            "1000",
            "5000"
    })
    void test_validateSalaryValid(double salary) throws IllegalSalaryException {
        assertTrue(RegisterStaffController.validateSalary(salary));
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "5001"
    })
    void test_validateSalaryInvalid(double salary) throws IllegalSalaryException {
        assertThrows(IllegalSalaryException.class,()->RegisterStaffController.validateSalary(salary));
    }

    @Test
    void test_signUpCorrectLibrarian()
    {

        assertEquals(new MockLibrarian("name","surname","e@gmail.com","29 12 2001","username","password",1000,"067 77 77 777"),registerStaffController.signUp("name","surname","e@gmail.com","29 12 2001","username","password",1000,"067 77 77 777",1));

    }

    @Test
    void test_signUpCorrectManager()
    {
        assertEquals(new Manager("name","surname","e@gmail.com","29 12 2001","username","password",1000,"067 77 77 777"),registerStaffController.signUp("name","surname","e@gmail.com","29 12 2001","username","password",1000,"067 77 77 777",2));

    }

    @Test
    void test_signUpIncorrectChoice()
    {
        assertNull(registerStaffController.signUp("name","surname","e@gmail.com","29 12 2001","username","password",1000,"067 77 77 777",3));
    }

    @Test
    void test_addPersonAccount()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertEquals(List.of(person),RegisterStaffController.getAccounts());
    }

    //equivalence class
    @Test
    void test_isAccountTrue()
    {
        Person person = new Librarian("n","s","e","b","u","p",1,"pno");
        assertEquals(person,RegisterStaffController.isAccount("u","p"));
    }

    @Test
    void test_isAccountFalseUsername()
    {
        Person person = new Librarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertNull(RegisterStaffController.isAccount("a","p"));

    }

    @Test
    void test_isAccountFalsePassword()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertNull(RegisterStaffController.isAccount("u","a"));
    }

    @Test
    void test_getLibrarians()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        person = new Manager("n","s","e","b","u","p",1,"pno");
        assertEquals(List.of(person),RegisterStaffController.getLibrarians());
    }

    @Test
    void test_getManagers()
    {
        Person person = new Manager("n","s","e","b","u","p",1,"pno");
        Person person1 = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person1);
        assertEquals(List.of(person),RegisterStaffController.getManagers());
    }

    @Test
    void test_writeToBinaryFileNoExceptions()
    {
        Person person = new Manager("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.readFromFile();
        assertEquals(List.of(person),RegisterStaffController.getAccounts());
    }

    @Test
    void test_writeToBinaryFileFileNotFound()
    {
        registerStaffController = new RegisterStaffController(new File("TestFilessss//personnel.dat"),new File("TestFiles//usernames.txt"),1);
        new Manager("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.readFromFile();
        assertEquals(new ArrayList<>(),RegisterStaffController.getAccounts());
    }

    @Test
    void test_writeToTextFile()
    {

        new Manager("n","s","e","b","u","p",1,"pno");
        new Administrator("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount( new MockLibrarian("n","s","e","b","u","p",1,"pno"));
        RegisterStaffController.writeToTextFile();
    }

    @Test
    void test_writeToTextFileNotFound()
    {
        registerStaffController = new RegisterStaffController(new File("TestFiles//personnel.dat"), new File("TestFilesss//usernames.txt"),1);
        RegisterStaffController.AddPersonAccount(new MockLibrarian("n","s","e","b","u","p",1,"pno"));
    }

    @Test
    void test_updateBinaryFileEmpty()
    {
        RegisterStaffController.updateBinaryFile();
        assertEquals(new ArrayList<Person>(),RegisterStaffController.getAccounts());

    }

    @Test
    void test_updateBinaryFile()
    {
        Person person = new MockLibrarian("n","s","e","b","u","p",1,"pno");
        RegisterStaffController.AddPersonAccount(person);
        RegisterStaffController.updateBinaryFile();
        assertEquals(List.of(person),RegisterStaffController.getAccounts());
    }

    @Test
    void test_updateBinaryFileNotFound()
    {
        registerStaffController = new RegisterStaffController(new File("TestFilesss//personnel.dat"), new File("TestFiles//usernames.txt"),1);
        RegisterStaffController.updateBinaryFile();
    }

    @Test
    void test_getEmployeesCost()
    {
        assertEquals(0, RegisterStaffController.getEmployeesCost());

        Person person=new MockLibrarian("n","s","e","b","u","p",100,"pno");
        RegisterStaffController.AddPersonAccount(person);
        assertEquals(100.0, RegisterStaffController.getEmployeesCost(),0.1);
    }

}
