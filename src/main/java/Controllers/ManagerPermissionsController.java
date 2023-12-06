package Controllers;

import Views.*;
import models.*;

public class ManagerPermissionsController extends Controller //ok
{

    private final ManagerPermissionsView managerPermissionsView;

    public ManagerPermissionsController(Person person, ManagerPermissionsView managerPermissionsView)
    {
        this.managerPermissionsView = managerPermissionsView;

        this.managerPermissionsView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(managerPermissionsView,person);

        });

        this.managerPermissionsView.getPermissionsCB().setOnAction(e->
        {
            if(this.managerPermissionsView.getPermissionsCB().getValue().equals("Manage categories"))
            {
                AddCategoriesPermissionView addCategoriesPermissionView = new AddCategoriesPermissionView(this.managerPermissionsView.getStage());
                new AddCategoriesPermissionController(person,addCategoriesPermissionView);
            }
            else if(this.managerPermissionsView.getPermissionsCB().getValue().equals("Add books"))
            {
                AddBooksPermissionView addBooksPermissionView = new AddBooksPermissionView(this.managerPermissionsView.getStage());
                new AddBooksPermissionController(person,addBooksPermissionView);
            }
            else if(this.managerPermissionsView.getPermissionsCB().getValue().equals("Delete books"))
            {
                DeleteBooksPermissionView deleteBooksPermissionView = new DeleteBooksPermissionView(this.managerPermissionsView.getStage());
                new DeleteBooksPermissionController(person,deleteBooksPermissionView);
            }
            else if(this.managerPermissionsView.getPermissionsCB().getValue().equals("Add copies"))
            {
                AddCopiesPermissionView addCopiesPermissionView = new AddCopiesPermissionView(this.managerPermissionsView.getStage());
                new AddCopiesPermissionController(person,addCopiesPermissionView);
            }
        });


    }
}
