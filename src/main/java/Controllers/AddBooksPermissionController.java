package Controllers;

import Views.AddBooksPermissionView;
import Views.ManagerPermissionsView;
import javafx.scene.control.CheckBox;
import models.Manager;
import models.Person;
import models.Controller;

import java.util.ArrayList;

public class AddBooksPermissionController extends Controller ///ok
{
    private final AddBooksPermissionView addBooksPermissionView;

    public AddBooksPermissionController(Person person, AddBooksPermissionView addBooksPermissionView)
    {
        this.addBooksPermissionView = addBooksPermissionView;

        this.addBooksPermissionView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(addBooksPermissionView,person);
        });

        this.addBooksPermissionView.getProceedBt().setOnAction(e->
        {

            removePermission();
            grantPermission();

            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addBooksPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });
    }

    public ArrayList<CheckBox> removePermission()
    {
        for(int i=0;i<this.addBooksPermissionView.getCheckBoxes1().size();i++)
        {
            if(this.addBooksPermissionView.getCheckBoxes1().get(i).isSelected())
            {
                ((Manager)this.addBooksPermissionView.getManagers1().get(i)).setAddBooks(false);
                RegisterStaffController.updateBinaryFile();
            }
        }

        return this.addBooksPermissionView.getCheckBoxes1();
    }

    public ArrayList<CheckBox> grantPermission()
    {
        for(int i=0;i<this.addBooksPermissionView.getCheckBoxes2().size();i++)
        {
            if(this.addBooksPermissionView.getCheckBoxes2().get(i).isSelected())
            {
                ((Manager)this.addBooksPermissionView.getManagers2().get(i)).setAddBooks(true);
                RegisterStaffController.updateBinaryFile();
            }
        }

        return this.addBooksPermissionView.getCheckBoxes2();

    }

}
