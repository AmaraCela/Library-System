package Controllers;

import Views.AddBooksPermissionView;
import Views.AdministratorView;
import Views.ManagerPermissionsView;
import models.Manager;
import models.Person;

public class AddBooksPermissionController {
    private final AddBooksPermissionView addBooksPermissionView;

    public AddBooksPermissionController(Person person, AddBooksPermissionView addBooksPermissionView)
    {
        this.addBooksPermissionView = addBooksPermissionView;

        this.addBooksPermissionView.getAdministratorPageBt().setOnAction(e->
        {
            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addBooksPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
//
        });

        this.addBooksPermissionView.getProceedBt().setOnAction(e->
        {
            for(int i=0;i<this.addBooksPermissionView.getCheckBoxes1().size();i++)
            {
                if(this.addBooksPermissionView.getCheckBoxes1().get(i).isSelected())
                {
                    ((Manager)this.addBooksPermissionView.getManagers1().get(i)).setAddBooks(false);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            for(int i=0;i<this.addBooksPermissionView.getCheckBoxes2().size();i++)
            {
                if(this.addBooksPermissionView.getCheckBoxes2().get(i).isSelected())
                {
                    ((Manager)this.addBooksPermissionView.getManagers2().get(i)).setAddBooks(true);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addBooksPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });
    }

}
