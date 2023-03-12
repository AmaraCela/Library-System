package Auxilaries;

public class IllegalSalaryException extends Exception{

    public IllegalSalaryException()
    {
        super("Salary can not be negative");
    }

}
