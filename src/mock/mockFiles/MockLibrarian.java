package mockFiles;

import models.Librarian;
import models.Person;

import java.util.Objects;

public class MockLibrarian extends Librarian {

//    double personalRevenue;
//    int numberOfBills;
//    int numOfBooksSold;
String name;
String surname;
String email;
String birthday;
String username;
String password;
double salary;
String phoneNo;


    public MockLibrarian(String name, String surname, String email, String birthday, String username, String password, double salary, String phoneNo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.phoneNo = phoneNo;
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Person) {
            if (Objects.equals(this.name, ((Person) obj).getName())) {
                if (Objects.equals(this.surname, ((Person) obj).getSurname())) {
                    if (Objects.equals(this.email, ((Person) obj).getEmail())) {
                        if (Objects.equals(this.birthday, ((Person) obj).getBirthday())) {
                            if (Objects.equals(this.phoneNo, ((Person) obj).getPhoneNo())) {
                                if (Objects.equals(this.username, ((Person) obj).getUsername())) {
                                    if (Objects.equals(this.password, ((Person) obj).getPassword())) {
                                        if (Objects.equals(this.salary, ((Person) obj).getSalary())) {
                                            return true;
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

            }
            return false;
        }
        return false;
    }
}
