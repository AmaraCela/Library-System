package Controllers;

import Views.DeleteBooksPermissionView;
import Views.ManagerPermissionsView;
import models.Manager;
import models.Person;
import models.Controller;

public class DeleteBooksPermissionController extends Controller//ok
{

    private final DeleteBooksPermissionView deleteBooksPermissionView;
    public DeleteBooksPermissionController(Person person, DeleteBooksPermissionView deleteBooksPermissionView)
    {
        this.deleteBooksPermissionView = deleteBooksPermissionView;

        this.deleteBooksPermissionView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(deleteBooksPermissionView,person);
        });

        this.deleteBooksPermissionView.getProceedBt().setOnAction(e->
        {
            for(int i=0;i<this.deleteBooksPermissionView.getCheckBoxes1().size();i++)
            {
                if(this.deleteBooksPermissionView.getCheckBoxes1().get(i).isSelected())
                {
                    ((Manager)this.deleteBooksPermissionView.getManagers1().get(i)).setDeleteBooks(false);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            for(int i=0;i<this.deleteBooksPermissionView.getCheckBoxes2().size();i++)
            {
                if(this.deleteBooksPermissionView.getCheckBoxes2().get(i).isSelected())
                {
                    ((Manager)this.deleteBooksPermissionView.getManagers2().get(i)).setDeleteBooks(true);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(deleteBooksPermissionView.getStage());
            new ManagerPermissionsController(person,managerPermissionsView);
        });
    }

}
