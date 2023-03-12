package models;

import java.io.Serial;
import java.io.Serializable;
import Controllers.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 6908505798151735320L;
    private String name;
   // private transient SimpleStringProperty nameProperty;
    private String surname;
   // private transient SimpleStringProperty surnameProperty;

    private String email;
    //private transient SimpleStringProperty emailProperty;
    private String birthday;
   // private transient final SimpleStringProperty birthdayProperty;

    private String username;
   // private transient SimpleStringProperty usernameProperty;
    private String password;
   // private transient SimpleStringProperty passwordProperty;
    private double salary;
   // private transient SimpleDoubleProperty salaryProperty;

    private String phoneNo;
   // private transient SimpleStringProperty phoneNoProperty;

    private static double employeeCost;


    public Person(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        this.name = name;
        //this.nameProperty = new SimpleStringProperty(name);
        this.surname = surname;
        //this.surnameProperty = new SimpleStringProperty(surname);
        this.email = email;
       // this.emailProperty = new SimpleStringProperty(email);
        this.birthday = birthday;
       // this.birthdayProperty = new SimpleStringProperty(birthday);
        this.username = username;
       // this.usernameProperty = new SimpleStringProperty(username);
        this.password = password;
       // this.passwordProperty = new SimpleStringProperty(password);
        this.salary = salary;
       // this.salaryProperty = new SimpleDoubleProperty(salary);
        this.phoneNo = phoneNo;
        //this.phoneNoProperty = new SimpleStringProperty(phoneNo);
        RegisterStaffController.AddPersonAccount(this);
        employeeCost+=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public abstract String personnelData();

    public static double getEmployeesCost()
    {
        return employeeCost;
    }

//    public String getNameProperty() {
//        return nameProperty.get();
//    }
//
//    public SimpleStringProperty namePropertyProperty() {
//        return nameProperty;
//    }
//
//    public String getSurnameProperty() {
//        return surnameProperty.get();
//    }
//
//    public SimpleStringProperty surnamePropertyProperty() {
//        return surnameProperty;
//    }
//
//    public String getEmailProperty() {
//        return emailProperty.get();
//    }
//
//    public SimpleStringProperty emailPropertyProperty() {
//        return emailProperty;
//    }
//
//    public String getBirthdayProperty() {
//        return birthdayProperty.get();
//    }
//
//    public SimpleStringProperty birthdayPropertyProperty() {
//        return birthdayProperty;
//    }
//
//    public String getUsernameProperty() {
//        return usernameProperty.get();
//    }
//
//    public SimpleStringProperty usernamePropertyProperty() {
//        return usernameProperty;
//    }
//
//    public String getPasswordProperty() {
//        return passwordProperty.get();
//    }
//
//    public SimpleStringProperty passwordPropertyProperty() {
//        return passwordProperty;
//    }
//
//    public double getSalaryProperty() {
//        return salaryProperty.get();
//    }
//
//    public SimpleDoubleProperty salaryPropertyProperty() {
//        return salaryProperty;
//    }
//
//    public String getPhoneNoProperty() {
//        return phoneNoProperty.get();
//    }
//
//    public SimpleStringProperty phoneNoPropertyProperty() {
//        return phoneNoProperty;
//    }

    public static double getEmployeeCost() {
        return employeeCost;
    }


}

