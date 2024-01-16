package Controllers;

import Auxilaries.HeaderlessObjectOutputStream;
import Auxilaries.IllegalSalaryException;
import Views.RegisterStaffView;
import models.Librarian;
import models.Manager;
import models.Person;
import models.Controller;

import java.io.*;
import java.util.ArrayList;

public class RegisterStaffController extends Controller//ok
{

    private static ArrayList<Person> accounts = new ArrayList<>();

    private static File file = new File("usernames.txt");
    private static File binaryFile = new File("employees.dat");

    private RegisterStaffView registerStaffView;


    public RegisterStaffController(File binaryFile, File textFile, int choice)
    {
        RegisterStaffController.binaryFile = binaryFile;
        RegisterStaffController.file = textFile;
    }


    public RegisterStaffController(Person administrator,RegisterStaffView registerStaffView,int choice)
    {

        RegisterStaffController.binaryFile = new File("employees.dat");
        RegisterStaffController.file = new File("usernames.txt");
        this.registerStaffView = registerStaffView;
        this.registerStaffView.getSignUpBt().setOnAction(e->
        {

            this.registerStaffView.getUsernameError().setVisible(false);
            this.registerStaffView.getPasswordError().setVisible(false);
            this.registerStaffView.getNameError().setVisible(false);
            this.registerStaffView.getSurnameError().setVisible(false);
            this.registerStaffView.getEmailError().setVisible(false);
            this.registerStaffView.getBirthdayError().setVisible(false);
            this.registerStaffView.getSalaryError().setVisible(false);
            this.registerStaffView.getPhoneError().setVisible(false);

            this.registerStaffView.getUnsuccessfulText().setVisible(false);
            this.registerStaffView.getSuccesfulText().setVisible(false);

            this.registerStaffView.getUsernameErrorLabel().setVisible(false);
            this.registerStaffView.getPasswordErrorLabel().setVisible(false);
            this.registerStaffView.getNameErrorLabel().setVisible(false);
            this.registerStaffView.getSurnameErrorLabel().setVisible(false);
            this.registerStaffView.getEmailErrorLabel().setVisible(false);
            this.registerStaffView.getBirthdayErrorLabel().setVisible(false);
            this.registerStaffView.getSalaryErrorLabel().setVisible(false);
            this.registerStaffView.getPhonenoErrorLabel().setVisible(false);

            signUpUI(choice);

            this.registerStaffView.getUsernameError().setOnMousePressed(e1->
            {

                this.registerStaffView.getUsernameErrorLabel().setVisible(true);

            });
            this.registerStaffView.getPasswordError().setOnMousePressed(e1->
            {

                this.registerStaffView.getPasswordErrorLabel().setVisible(true);

            });

            this.registerStaffView.getNameError().setOnMousePressed(e1->
            {
                //gridPane.setVgap(1);
                this.registerStaffView.getNameErrorLabel().setVisible(true);

            });

            this.registerStaffView.getSurnameError().setOnMousePressed(e1->
            {

                this.registerStaffView.getSurnameErrorLabel().setVisible(true);
            });

            this.registerStaffView.getEmailError().setOnMousePressed(e1->
            {

                this.registerStaffView.getEmailErrorLabel().setVisible(true);

            });
            this.registerStaffView.getPhoneError().setOnMousePressed(e1->
            {

                this.registerStaffView.getPhonenoErrorLabel().setVisible(true);

            });
            this.registerStaffView.getBirthdayError().setOnMousePressed(e1->
            {
                this.registerStaffView.getBirthdayErrorLabel().setVisible(true);
            });
            this.registerStaffView.getSalaryError().setOnMousePressed(e1->
            {
                this.registerStaffView.getSalaryErrorLabel().setVisible(true);

            });


        });

        this.registerStaffView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(registerStaffView,administrator);

        });
    }

    public void signUpUI(int choice)
    {
        boolean flag = true;
        try {
            String username = this.registerStaffView.getUsernameTf().getText();
            if(!validateUsername(username))
            {
                this.registerStaffView.getUsernameError().setVisible(true);
                this.registerStaffView.getUsernameTf().clear();
                flag = false;
            }
            String password = this.registerStaffView.getPasswordTf().getText();
            if(!validatePassword(password))
            {
                this.registerStaffView.getPasswordError().setVisible(true);
                this.registerStaffView.getPasswordTf().clear();
                flag = false;
            }
            String name = this.registerStaffView.getNameTf().getText();
            if(!validateName(name))
            {
                this.registerStaffView.getNameError().setVisible(true);
                this.registerStaffView.getNameTf().clear();
                flag = false;
            }
            String surname = this.registerStaffView.getSurnameTf().getText();
            if(!validateSurname(surname))
            {
                this.registerStaffView.getSurnameTf().clear();
                this.registerStaffView.getSurnameError().setVisible(true);
                flag = false;
            }
            String email = this.registerStaffView.getEmailTf().getText();
            if(!validateEmail(email))
            {   this.registerStaffView.getEmailTf().clear();
                this.registerStaffView.getEmailError().setVisible(true);
                flag = false;
            }
            String birthday = this.registerStaffView.getBirthdayTf().getText();
            if(!validateBirthday(birthday))
            {
                this.registerStaffView.getBirthdayTf().clear();
                this.registerStaffView.getBirthdayError().setVisible(true);
                flag = false;
            }
            String phoneNo = this.registerStaffView.getPhoneNoTf().getText();
            if(!validatePhoneNo(phoneNo))
            {
                this.registerStaffView.getPhoneError().setVisible(true);
                this.registerStaffView.getPhoneNoTf().clear();
                flag = false;
            }
            double salary = Double.parseDouble(this.registerStaffView.getSalaryTf().getText());

//            if(signUp(name, surname, email, birthday, username, password, salary, phoneNo, choice) != null)
            if (flag && validateSalary(salary))
            {

                this.registerStaffView.getPhoneNoTf().clear();
                this.registerStaffView.getEmailTf().clear();
                this.registerStaffView.getSurnameTf().clear();
                this.registerStaffView.getNameTf().clear();
                this.registerStaffView.getPasswordTf().clear();
                this.registerStaffView.getUsernameTf().clear();
                this.registerStaffView.getSalaryTf().clear();
                this.registerStaffView.getBirthdayTf().clear();
                this.registerStaffView.getSuccesfulText().setVisible(true);
                this.registerStaffView.setBottom(this.registerStaffView.getSuccesfulText());
                signUp(name, surname, email, birthday, username, password, salary, phoneNo, choice);

            }
            else
            {
                this.registerStaffView.getUnsuccessfulText().setVisible(true);
                this.registerStaffView.getSalaryErrorLabel().setVisible(true);
                this.registerStaffView.setBottom(this.registerStaffView.getUnsuccessfulText());
            }
        }
        catch (IllegalSalaryException ex)
        {
            this.registerStaffView.getSalaryError().setVisible(true);
            this.registerStaffView.getSalaryTf().clear();
        }
        catch (NumberFormatException ex) {

            this.registerStaffView.getSalaryError().setVisible(true);
            this.registerStaffView.getSalaryTf().clear();

        }
    }

    public static void readFromFile()
    {
        accounts.clear();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(binaryFile))){

            Object person;
            while ((person=objectInputStream.readObject())!=null)
            {
                accounts.add((Person) person);
            }
        }
        catch (EOFException e)
        {
            System.out.println("End of file ");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Binary class not found!");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found!");
        }
        catch (IOException ex)
        {
            System.out.println("IOException ");
            ex.printStackTrace();
        }
    }

//    private boolean validateSignUp(String name, String surname, String email, String birthday, String username, String password,String phoneNo)
//    {
//
//        if (validateName(name))
//        {
//            if (validateSurname(surname))
//            {
//                if (validateEmail(email))
//                {
//                    if(validateBirthday(birthday))
//                    {
//                        if(validatePhoneNo(phoneNo))
//                        {
//                            if (validateUsername(username))
//                            {
//                                if (validatePassword(password))
//                                {
//                                    return true;
//                                }
//                                return false;
//                            }
//                            return false;
//                        }
//                        return false;
//                    }
//                    return false;
//                }
//                return false;
//            }
//            return false;
//        }
//        return false;
//
//    }


    public static boolean validateSalary(double salary) throws IllegalSalaryException
    {
        if(salary<=100 || salary>=5001)
        {

            throw new IllegalSalaryException();
        }
        return true;

    }
    public static boolean validateUsername(String username)
    {
        if(username!=null)
        {
            for(Person account :accounts)
            {
                if(username.equals(account.getUsername()))
                {
                    return false;
                }
            }
            return username.length() != 0;
        }
        return false;
    }

    public static boolean validatePassword(String password)
    {
        if(password!=null)
        {
            return password.length() >= 8;
        }
        return false;
    }

    public static boolean validateName(String name)
    {

        if(name.length()==0 || name.length()>35)
        {
            return false;
        }
        return true;
    }

    public static boolean validateSurname(String surname)
    {
        if(surname.length() == 0 || surname.length()>35)
        {
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email)
    {
        if(!email.matches(".+@.+\\.com"))
        {
            return false;
        }
        return true;
    }

    public static boolean validateBirthday(String birthday)
    {
        if(!birthday.matches("\\d{2}.\\d{2}.\\d{4}"))
        {
            return false;
        }
        return true;
    }

    public static boolean validatePhoneNo(String phoneNo)
    {
        if(!phoneNo.matches("06\\d\\s\\d{2}\\s\\d{2}\\s\\d{3}"))
        {
            System.out.println("Phone problem");
            return false;
        }
        return true;
    }


    public Person signUp(String name, String surname, String email, String birthday, String username, String password, double salary,String phoneNo,int choice)
    {
        if(choice == 1)
        {
            return new Librarian(name,surname,email,birthday,username,password,salary,phoneNo);
        }
        if(choice == 2)
        {
            return new Manager(name,surname,email,birthday,username,password,salary,phoneNo);
        }
        return null;

    }

    public static ArrayList<Person> getLibrarians()
    {
        ArrayList<Person> librarians = new ArrayList<>();

        for (int i=0;i<accounts.size();i++)
        {
            if(accounts.get(i) instanceof Librarian)
            {
                librarians.add( accounts.get(i));
            }
        }
        return librarians;
    }

    public static ArrayList<Person> getManagers()
    {
        ArrayList<Person> managers = new ArrayList<>();

        for (int i=0;i<accounts.size();i++)
        {
            if(accounts.get(i) instanceof Manager)
            {
                managers.add(accounts.get(i));
            }
        }
        return managers;
    }
    public static void AddPersonAccount(Person person)
    {
        accounts.add(person);

        writeToTextFile();
        writeToBinaryFile(person);


    }

    public static Person isAccount(String username, String password)
    {
        for(int i = 0;i<accounts.size();i++)
        {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password))
            {

                return accounts.get(i);
            }
        }
        return null;
    }

//    public static Librarian getLibrarian(String username)
//    {
//
//        for(Person account:accounts)
//        {
//            if(account.getUsername().equals(username))
//            {
//                return (Librarian) account;
//            }
//        }
//        return null;
//    }
//    public static Manager getManager(String username)
//    {
//
//        for(Person account:accounts)
//        {
//            if(account.getUsername().equals(username))
//            {
//                return (Manager) account;
//            }
//        }
//        return null;
//    }

    public static ArrayList<Person> getAccounts() {
        return accounts;
    }

//    public static ArrayList<String> getLibrarianUsernames()
//    {
//        ArrayList <String> librarianUsernames = new ArrayList<>();
//        for(Person account: accounts)
//        {
//            if(account instanceof Librarian)
//            {
//                librarianUsernames.add(account.getUsername());
//                System.out.println(account.getUsername());
//            }
//        }
//        return librarianUsernames;
//    }
//
//    public static ArrayList<String> getManagerUsernames()
//    {
//        ArrayList <String> managerUsernames = new ArrayList<>();
//        for(int i=0;i< accounts.size();i++)
//        {
//            if(accounts.get(i) instanceof Manager)
//            {
//                managerUsernames.add(accounts.get(i).getUsername());
//            }
//        }
//        return managerUsernames;
//    }
//
//    public static boolean deleteStaff(String username)
//    {
//        for(int i=0;i<accounts.size();i++)
//        {
//            if(accounts.get(i).getUsername().equals(username))
//            {
//                accounts.remove(i);
//                updateBinaryFile();
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static void writeToTextFile()
    {
        try(PrintWriter writer = new PrintWriter(file);) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i)  instanceof Librarian)
                {
                    writer.println("Librarian: "+ accounts.get(i).getUsername()+" "+accounts.get(i).getPassword());
                }
                else if(accounts.get(i) instanceof Manager)
                {
                    writer.println("Manager: "+ accounts.get(i).getUsername()+" "+accounts.get(i).getPassword());
                }
                else
                {
                    writer.println("Administrator: "+ accounts.get(i).getUsername()+" "+accounts.get(i).getPassword());
                }

            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Text file not found;");
        }
    }

    public static void writeToBinaryFile(Person person)
    {
        try
        {
            FileOutputStream outputStream = new FileOutputStream(binaryFile, true);
            ObjectOutputStream writer;
            if (binaryFile.length() > 0) {
                writer = new HeaderlessObjectOutputStream(outputStream);

            }
            else {
                writer = new ObjectOutputStream(outputStream);

            }
            writer.writeObject(person);
            writer.close();

        }
        catch (IOException ex)
        {
            System.out.println("Input Output exception thrown ne write to binary func");
        }

    }

    public static void updateBinaryFile()
    {

        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(binaryFile,false);)
        {
            outputStream = new ObjectOutputStream(output);

            for (int i=0 ;i< accounts.size();i++)
            {
                outputStream.writeObject(accounts.get(i));
            }

            outputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found in writing books");
        }
        catch (IOException e)
        {
            System.out.println("IOException in writing books");

        }
    }

    public static double getEmployeesCost()
    {
        double cost = 0;
        for (Person person:accounts)
        {
            cost+=person.getSalary();
        }
        return cost;
    }

    public static void setFile(File file) {
        RegisterStaffController.file = file;
    }

    public static void setBinaryFile(File binaryFile) {
        RegisterStaffController.binaryFile = binaryFile;
    }
}
