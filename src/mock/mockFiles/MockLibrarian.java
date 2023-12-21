package mockFiles;

import models.Librarian;

public class MockLibrarian extends Librarian {

//    double personalRevenue;
//    int numberOfBills;
//    int numOfBooksSold;
    public MockLibrarian(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        super(name, surname, email, birthday, username, password, salary, phoneNo);
    }
    @Override
    public void setPersonalRevenue(double total) {
//        personalRevenue+=total;
    }
    @Override
    public void setNumberOfBills(int num){
//        numberOfBills++;
    }
    public void setNumOfBooksSold(int numOfBooksSold) {
//        this.numOfBooksSold += numOfBooksSold;
    }

}
