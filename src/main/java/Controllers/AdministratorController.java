package Controllers;

import Views.*;
import models.Person;

public class AdministratorController {
    private final AdministratorView administratorView;

    public AdministratorController(Person administrator, AdministratorView administratorView)
    {
        this.administratorView = administratorView;

        this.administratorView.getLogOutItem().setOnAction(e->
        {
            LogInView logInView=new LogInView(administratorView.getStage());
            new LogInController(logInView);

        });

        this.administratorView.getRegisterLibrarian().setOnAction(e->
        {
            RegisterStaffView registerStaffView = new RegisterStaffView(administratorView.getStage());
            RegisterStaffController registerStaffController = new RegisterStaffController(administrator,registerStaffView,1);
        });
        this.administratorView.getRegisterManager().setOnAction(e->
        {
            RegisterStaffView registerStaffView = new RegisterStaffView(administratorView.getStage());
            RegisterStaffController registerStaffController = new RegisterStaffController(administrator,registerStaffView,2);
        });

        this.administratorView.getViewLibrarian().setOnAction(e->
        {
            DeleteStaffView viewStaffView = new DeleteStaffView(administratorView.getStage(),1);
            new DeleteStaffController(administrator,viewStaffView);
        });
        this.administratorView.getViewManager().setOnAction(e->
        {
            DeleteStaffView viewStaffView = new DeleteStaffView(administratorView.getStage(),2);
            new DeleteStaffController(administrator,viewStaffView);
        });
        this.administratorView.getModifyLibrarian().setOnAction(e->
        {
            ModifyStaffView modifyStaffView = new ModifyStaffView(administratorView.getStage(),1);
            new ModifyStaffController(administrator,modifyStaffView);
        });
        this.administratorView.getModifyManager().setOnAction(e->
        {
            ModifyStaffView modifyStaffView = new ModifyStaffView(administratorView.getStage(),2);
            new ModifyStaffController(administrator,modifyStaffView);
        });
        this.administratorView.getAddBookCatgory().setOnAction(e->
        {
            AddCategoryView addCategoryView = new AddCategoryView(administratorView.getStage());
            CategoryController categoryController = new CategoryController(administrator,addCategoryView);

        });
        this.administratorView.getSupplyBooksItem().setOnAction(e->
        {
            SupplyBooksView supplyBooksView = new SupplyBooksView(administratorView.getStage());
            new SupplyBooksController(administrator,supplyBooksView);
        });
        this.administratorView.getViewBooks().setOnAction(e->
        {
            ManageBooksView manageBooksView = new ManageBooksView(administratorView.getStage(),3);
            new ManageBooksController(administrator,manageBooksView);
        });
        this.administratorView.getPermissionsLibrarianItem().setOnAction(e->
        {
            PermissionsLibrarianView permissionsLibrarianView = new PermissionsLibrarianView(administratorView.getStage());
            new PermissionsLibrarianController(administrator,permissionsLibrarianView);
        });
        this.administratorView.getPermissionsManagerItem().setOnAction(e->
        {
            ManagerPermissionsView managerPermissionsView = new ManagerPermissionsView(administratorView.getStage());
            new ManagerPermissionsController(administrator,managerPermissionsView);

        });
        this.administratorView.getAddStockItem().setOnAction(e->
        {
            AddToStockView addToStockView = new AddToStockView(administratorView.getStage());
            new AddToStockController(administrator,addToStockView);
        });


    }
}
