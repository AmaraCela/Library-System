package models;

import java.io.Serial;

public class Manager extends Person{

    @Serial
    private static final long serialVersionUID = -7503709717831086504L;

    public Manager(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        super(name, surname, email, birthday, username, password, salary,phoneNo);

    }

    @Override
    public String personnelData() {
        return "Manager: "+ super.getName()+" "+ super.getSurname()+" Salary: "+ super.getSalary();
    }
}
