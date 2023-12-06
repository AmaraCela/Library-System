package Controllers;

import Views.DeleteStaffView;
import javafx.collections.ObservableList;
import models.Person;
import models.Controller;

import java.util.ArrayList;

public class DeleteStaffController extends Controller //ok
{

    private final DeleteStaffView deleteStaffView;
    public DeleteStaffController(Person administrator, DeleteStaffView viewStaffView)
    {
        this.deleteStaffView = viewStaffView;
        this.deleteStaffView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(deleteStaffView,administrator);
        });

        this.deleteStaffView.getDeleteBt().setOnAction(e->
        {
            delete();

            RegisterStaffController.updateBinaryFile();
            updateTable();

        });


    }

    public ArrayList<Person> delete()
    {
        ObservableList<Person> selectedAccounts = this.deleteStaffView.getTableView().getSelectionModel().getSelectedItems();
        RegisterStaffController.getAccounts().removeAll(selectedAccounts);
        return RegisterStaffController.getAccounts();
    }

    public ObservableList<Person> updateTable()
    {
        this.deleteStaffView.getTableView().getItems().clear();
        if(this.deleteStaffView.getChoice()==1)
        {
            this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
        }else
        {
            this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());

        }
        return this.deleteStaffView.getTableView().getItems();
    }

}
