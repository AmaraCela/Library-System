package Controllers;

import Views.AdministratorView;
import Views.PermissionsLibrarianView;
import models.Librarian;
import models.Person;
import models.Controller;

public class PermissionsLibrarianController extends Controller //ok
{

    private final PermissionsLibrarianView permissionsLibrarianView;
    public PermissionsLibrarianController(Person administrator, PermissionsLibrarianView permissionsLibrarianView)
    {
        this.permissionsLibrarianView = permissionsLibrarianView;

        this.permissionsLibrarianView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(permissionsLibrarianView,administrator);
        });
        this.permissionsLibrarianView.getProceedBt().setOnAction(e->
        {
            for(int i=0;i<this.permissionsLibrarianView.getCheckBoxes1().size();i++)
            {
                if(this.permissionsLibrarianView.getCheckBoxes1().get(i).isSelected())
                {
                    ((Librarian)this.permissionsLibrarianView.getLibrarians1().get(i)).setCheckOutPermission(false);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            for(int i=0;i<this.permissionsLibrarianView.getCheckBoxes2().size();i++)
            {
                if(this.permissionsLibrarianView.getCheckBoxes2().get(i).isSelected())
                {
                    ((Librarian)this.permissionsLibrarianView.getLibrarians2().get(i)).setCheckOutPermission(true);
                    RegisterStaffController.updateBinaryFile();
                }
            }

            AdministratorView administratorView = new AdministratorView(permissionsLibrarianView.getStage());
            new AdministratorController(administrator,administratorView);

        });


    }
}
