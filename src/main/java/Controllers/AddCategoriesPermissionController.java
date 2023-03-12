package Controllers;

import Views.AddCategoriesPermissionView;
import Views.AdministratorView;
import Views.ManagerPermissionsView;
import models.Librarian;
import models.Manager;
import models.Person;

public class AddCategoriesPermissionController {

    private final AddCategoriesPermissionView addCategoriesPermissionView;

    public AddCategoriesPermissionController(Person person, AddCategoriesPermissionView addCategoriesPermissionView)
    {
        this.addCategoriesPermissionView = addCategoriesPermissionView;

        this.addCategoriesPermissionView.getAdministratorPageBt().setOnAction(e->
        {
            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addCategoriesPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });

        this.addCategoriesPermissionView.getProceedBt().setOnAction(e->
        {
            for(int i=0;i<this.addCategoriesPermissionView.getCheckBoxes1().size();i++)
            {
                if(this.addCategoriesPermissionView.getCheckBoxes1().get(i).isSelected())
                {
                    ((Manager)this.addCategoriesPermissionView.getManagers1().get(i)).setManageCategories(false);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            for(int i=0;i<this.addCategoriesPermissionView.getCheckBoxes2().size();i++)
            {
                if(this.addCategoriesPermissionView.getCheckBoxes2().get(i).isSelected())
                {
                    ((Manager)this.addCategoriesPermissionView.getManagers2().get(i)).setManageCategories(true);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addCategoriesPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });
    }

}
