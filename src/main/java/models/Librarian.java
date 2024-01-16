package models;

import java.io.Serial;

public class Librarian extends Person{
    @Serial
    private static final long serialVersionUID = -6846668280553976186L;
    private double personalRevenue;
    private int numberOfBills;
    private int numOfBooksSold;
    public Librarian(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo)  {
        super(name, surname, email, birthday, username, password, salary,phoneNo);

    }

    public Librarian()
    {

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

    //mock
    public void setNumberOfBills(int num)
    {
        numberOfBills+=num;
    }

    public int getNumberOfBills()
    {
        return numberOfBills;
    }

    public int getNumOfBooksSold() {
        return numOfBooksSold;
    }

    //mock
    public void setNumOfBooksSold(int numOfBooksSold) {
        this.numOfBooksSold += numOfBooksSold;
    }
}
