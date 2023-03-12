package models;

import java.io.Serial;

public class Librarian extends Person{
    @Serial
    private static final long serialVersionUID = -6846668280553976186L;
    private double personalRevenue;
    private int numberOfBills;
    private int numOfBooksSold;

    private boolean checkOutPermission = true;
    public Librarian(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo)  {
        super(name, surname, email, birthday, username, password, salary,phoneNo);


    }

    public void setPersonalRevenue(double total)
    {
        personalRevenue+=total;
    }

    public double getPersonalRevenue()
    {

        return personalRevenue;
    }
    @Override
    public String personnelData() {
        return "Librarian: "+ super.getName()+" "+ super.getSurname()+" Salary: "+ super.getSalary();
    }

    public void setNumberOfBills()
    {
        numberOfBills++;
    }

    public int getNumberOfBills()
    {
        return numberOfBills;
    }


    public boolean isCheckOutPermission() {
        return checkOutPermission;
    }

    public void setCheckOutPermission(boolean checkOutPermission) {
        this.checkOutPermission = checkOutPermission;
    }

    public int getNumOfBooksSold() {
        return numOfBooksSold;
    }


    public void setNumOfBooksSold(int numOfBooksSold) {
        this.numOfBooksSold += numOfBooksSold;
    }
}
