package Controllers;

import Views.AddCategoriesPermissionView;
import Views.ManagerPermissionsView;
import models.Manager;
import models.Person;
import models.Controller;

public class AddCategoriesPermissionController extends Controller ///ok
{

    private final AddCategoriesPermissionView addCategoriesPermissionView;

    public AddCategoriesPermissionController(Person person, AddCategoriesPermissionView addCategoriesPermissionView)
    {
        this.addCategoriesPermissionView = addCategoriesPermissionView;

        this.addCategoriesPermissionView.getAdministratorPageBt().setOnAction(e->
        {
           this.goBack(addCategoriesPermissionView,person);
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
