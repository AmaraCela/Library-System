package models;

import java.io.Serial;

public class Manager extends Person{

    @Serial
    private static final long serialVersionUID = -7503709717831086504L;
    private boolean manageCategories = true;

    private boolean addBooks = true;
    private boolean deleteBooks = true;
    private boolean addToStock = true;
    public Manager(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        super(name, surname, email, birthday, username, password, salary,phoneNo);

    }

    @Override
    public String personnelData() {
        return "Manager: "+ super.getName()+" "+ super.getSurname()+" Salary: "+ super.getSalary();
    }



    public boolean isAddBooks() {
        return addBooks;
    }

    public boolean isDeleteBooks() {
        return deleteBooks;
    }



    public void setAddBooks(boolean addBooks) {
        this.addBooks = addBooks;
    }

    public void setDeleteBooks(boolean deleteBooks) {
        this.deleteBooks = deleteBooks;
    }

    public boolean isAddToStock() {
        return addToStock;
    }

    public void setAddToStock(boolean addToStock) {
        this.addToStock = addToStock;
    }

    public boolean isManageCategories() {
        return manageCategories;
    }

    public void setManageCategories(boolean manageCategories) {
        this.manageCategories = manageCategories;
    }
}
