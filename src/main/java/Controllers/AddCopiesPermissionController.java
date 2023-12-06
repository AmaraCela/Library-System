package Controllers;

import Views.AddCopiesPermissionView;
import Views.ManagerPermissionsView;
import models.Manager;
import models.Person;
import models.Controller;

public class AddCopiesPermissionController extends Controller //ok
{

    private final AddCopiesPermissionView addCopiesPermissionView;

    public AddCopiesPermissionController(Person person, AddCopiesPermissionView addCopiesPermissionView)
    {
        this.addCopiesPermissionView = addCopiesPermissionView;

        this.addCopiesPermissionView.getAdministratorPageBt().setOnAction(e->
        {
           this.goBack(addCopiesPermissionView,person);
        });

        this.addCopiesPermissionView.getProceedBt().setOnAction(e->
        {
            for(int i=0;i<this.addCopiesPermissionView.getCheckBoxes1().size();i++)
            {
                if(this.addCopiesPermissionView.getCheckBoxes1().get(i).isSelected())
                {
                    ((Manager)this.addCopiesPermissionView.getManagers1().get(i)).setAddToStock(false);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            for(int i=0;i<this.addCopiesPermissionView.getCheckBoxes2().size();i++)
            {
                if(this.addCopiesPermissionView.getCheckBoxes2().get(i).isSelected())
                {
                    ((Manager)this.addCopiesPermissionView.getManagers2().get(i)).setAddToStock(true);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(addCopiesPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });
    }

}
