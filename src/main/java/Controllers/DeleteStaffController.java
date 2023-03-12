package Controllers;

import Views.AdministratorView;
import Views.DeleteStaffView;
import Views.DeleteStaffView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import models.*;

public class DeleteStaffController {

    private final DeleteStaffView deleteStaffView;
    public DeleteStaffController(Person administrator, DeleteStaffView viewStaffView)
    {
        this.deleteStaffView = viewStaffView;
        this.deleteStaffView.getAdministratorPageBt().setOnAction(e->
        {
            AdministratorView administratorView = new AdministratorView(viewStaffView.getStage());
            new AdministratorController(administrator,administratorView);

        });

        this.deleteStaffView.getDeleteBt().setOnAction(e->
        {
            ObservableList<Person> selectedAccounts = this.deleteStaffView.getTableView().getSelectionModel().getSelectedItems();
            System.out.println(this.deleteStaffView.getTableView().getSelectionModel().getSelectedItems().isEmpty());


            RegisterStaffController.getAccounts().removeAll(selectedAccounts);


            RegisterStaffController.updateBinaryFile();
            this.deleteStaffView.getTableView().getItems().clear();
            if(this.deleteStaffView.getChoice()==1)
            {
                this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
            }else
            {
                this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
            }

        });


    }

}
