package Controllers;

import Auxilaries.IllegalSalaryException;
import Views.ModifyStaffView;
import models.Person;
import models.Controller;

import java.util.InputMismatchException;

public class ModifyStaffController extends Controller //ok
{

    private final ModifyStaffView modifyStaffView;


    public ModifyStaffController(Person administrator,ModifyStaffView modifyStaffView)
    {

        this.modifyStaffView = modifyStaffView;
        this.modifyStaffView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(modifyStaffView,administrator);

        });


        this.modifyStaffView.getUsernameColumn().setOnEditCommit(e->
        {

            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);

            String username = e.getNewValue();
            if(!RegisterStaffController.validateUsername(username))
            {
                this.modifyStaffView.getUsernameErrorLabel().setVisible(true);
                if(this.modifyStaffView.getChoice()==1)
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1)
                {
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setUsername(username);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setUsername(username);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }

                RegisterStaffController.updateBinaryFile();
            }
        });
        this.modifyStaffView.getNameColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            String name = e.getNewValue();
            if(!RegisterStaffController.validateName(name))
            {
               this.modifyStaffView.getNameErrorLabel().setVisible(true);

                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1)
                {
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setName(name);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setName(name);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }

                RegisterStaffController.updateBinaryFile();

            }

        });
        this.modifyStaffView.getSurnameColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            String surname = e.getNewValue();
            if(!RegisterStaffController.validateSurname(surname))
            {
                this.modifyStaffView.getSurnameErrorLabel().setVisible(true);
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1)
                {
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setSurname(surname);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else {
                RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setSurname(surname);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());}
                RegisterStaffController.updateBinaryFile();
            }
        });

        this.modifyStaffView.getEmailColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            String email = e.getNewValue();
            if(!RegisterStaffController.validateEmail(email))
            {
                this.modifyStaffView.getEmailErrorLabel().setVisible(true);
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1){
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setEmail(email);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setEmail(email);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
                RegisterStaffController.updateBinaryFile();
            }
        });

        this.modifyStaffView.getBirthdayColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            String birthday = e.getNewValue();
            if(!RegisterStaffController.validateBirthday(birthday))
            {
                this.modifyStaffView.getBirthdayErrorLabel().setVisible(true);
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1)
                {
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setBirthday(birthday);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setBirthday(birthday);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }

                RegisterStaffController.updateBinaryFile();
            }
        });
        this.modifyStaffView.getPhonenoColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            String phoneNo = e.getNewValue();
            if(!RegisterStaffController.validatePhoneNo(phoneNo))
            {
                this.modifyStaffView.getPhonenoErrorLabel().setVisible(true);
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
            }
            else
            {
                if(this.modifyStaffView.getChoice()==1){
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setPhoneNo(phoneNo);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setPhoneNo(phoneNo);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
                RegisterStaffController.updateBinaryFile();
            }
        });
        this.modifyStaffView.getSalaryColumn().setOnEditCommit(e->
        {
            this.modifyStaffView.getNameErrorLabel().setVisible(false);
            this.modifyStaffView.getSurnameErrorLabel().setVisible(false);
            this.modifyStaffView.getEmailErrorLabel().setVisible(false);
            this.modifyStaffView.getUsernameErrorLabel().setVisible(false);
            this.modifyStaffView.getPhonenoErrorLabel().setVisible(false);
            this.modifyStaffView.getSalaryErrorLabel().setVisible(false);
            this.modifyStaffView.getBirthdayErrorLabel().setVisible(false);
            try{

                String salaryString = String.valueOf(e.getNewValue());
                double salary = Double.parseDouble(salaryString);

            if(salary<=0)
            {
               throw new IllegalSalaryException();

            }
            else
            {
                if(this.modifyStaffView.getChoice()==1)
                {
                    RegisterStaffController.getLibrarians().get(e.getTablePosition().getRow()).setSalary(salary);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    RegisterStaffController.getManagers().get(e.getTablePosition().getRow()).setSalary(salary);
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }

                RegisterStaffController.updateBinaryFile();
            }}
            catch (NumberFormatException ex)
            {
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
                this.modifyStaffView.getEmailErrorLabel().setVisible(true);
                ex.printStackTrace();
            }
            catch (InputMismatchException ex)
            {
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
                this.modifyStaffView.getEmailErrorLabel().setVisible(true);
                ex.printStackTrace();
            }
            catch (IllegalSalaryException ex)
            {
                if(this.modifyStaffView.getChoice()==1)
                {

                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
                }
                else
                {
                    this.modifyStaffView.getTableView().getItems().clear();
                    this.modifyStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
                }
                this.modifyStaffView.getEmailErrorLabel().setVisible(true);
            }

        });



    }


}
