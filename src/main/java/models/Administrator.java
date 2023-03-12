package models;

import java.io.Serial;

public class Administrator extends Person{
    @Serial
    private static final long serialVersionUID = 2115824568291102384L;

    public Administrator(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        super(name, surname, email, birthday, username, password, salary,phoneNo);
    }

    @Override
    public String personnelData() {
        return "Administrator: "+ super.getName()+" "+ super.getSurname()+" Salary: "+ super.getSalary();
    }
}
