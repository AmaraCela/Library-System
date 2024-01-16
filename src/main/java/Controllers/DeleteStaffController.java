//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controllers;

import Views.DeleteStaffVieww;
import javafx.collections.ObservableList;
import models.Controller;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class DeleteStaffController extends Controller {
    private DeleteStaffVieww deleteStaffView;


    public DeleteStaffController(Person administrator, DeleteStaffVieww viewStaffView) {
        this.deleteStaffView = viewStaffView;
        this.deleteStaffView.getAdministratorPageBt().setOnAction((e) -> {
            this.goBack(this.deleteStaffView, administrator);
        });
        this.deleteStaffView.getDeleteBt().setOnAction((e) -> {
            ObservableList<Person> selectedAccounts = this.deleteStaffView.getTableView().getSelectionModel().getSelectedItems();
            this.delete(selectedAccounts);
            RegisterStaffController.updateBinaryFile();
            this.updateTable();
        });
    }

    public DeleteStaffController(){}

    public ArrayList<Person> delete(List<Person> selectedAccounts) {
       RegisterStaffController.getAccounts().removeAll(selectedAccounts);
        return RegisterStaffController.getAccounts();
    }

    public ObservableList<Person> updateTable() {
        this.deleteStaffView.getTableView().getItems().clear();
        if (this.deleteStaffView.getChoice() == 1) {
            this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getLibrarians());
        } else {
            this.deleteStaffView.getTableView().getItems().addAll(RegisterStaffController.getManagers());
        }

        return this.deleteStaffView.getTableView().getItems();
    }
}
