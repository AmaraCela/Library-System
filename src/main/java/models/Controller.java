package models;

import Controllers.*;
import Views.*;
import javafx.scene.layout.BorderPane;

import java.util.Objects;

public abstract class Controller {
    public Controller goBack(BorderPane currentView, Person person)
    {
        if(Objects.requireNonNull(currentView) instanceof AdministratorView)
        {
            LogInView logInView=new LogInView(((AdministratorView) currentView).getStage());
            return new LogInController(logInView);
        }
        else if(Objects.requireNonNull(currentView) instanceof CheckOutView)
        {
            ManageBooksView manageBooksView ;
            if (person instanceof Librarian) {
                manageBooksView = new ManageBooksView(((CheckOutView) currentView).getStage(),1);
            } else if (person instanceof Manager) {
                manageBooksView = new ManageBooksView(((CheckOutView)currentView).getStage(),2);
            } else {
                manageBooksView = new ManageBooksView(((CheckOutView)currentView).getStage(),3);
            }

            return new ManageBooksController(person, manageBooksView);
        }
        else if(Objects.requireNonNull(currentView) instanceof DeleteStaffView)
        {
            AdministratorView administratorView = new AdministratorView(((DeleteStaffView)currentView).getStage());
            return new AdministratorController(person,administratorView);
        }
        else if(Objects.requireNonNull(currentView) instanceof IncomesView)
        {
            ManagerView managerView = new ManagerView(((IncomesView)currentView).getStage());
            return new ManagerController(person,managerView);
        }
        else if(Objects.requireNonNull(currentView) instanceof ManageBooksView)
        {
            if (person instanceof Administrator)
            {
                AdministratorView administratorView = new AdministratorView(((ManageBooksView)currentView).getStage());
                return new AdministratorController(person,administratorView);
            }
            else if(person instanceof Manager)
            {
                ManagerView managerView = new ManagerView(((ManageBooksView)currentView).getStage());
                return new ManagerController(person,managerView);
            }
            else if(person instanceof Librarian)
            {
                LibrarianView librarianView = new LibrarianView(((ManageBooksView)currentView).getStage());
                return new LibrarianController(person,librarianView);
            }
        }
        else if(Objects.requireNonNull(currentView) instanceof ModifyStaffView)
        {
            AdministratorView administratorView = new AdministratorView(((ModifyStaffView)currentView).getStage());
            return new AdministratorController(person,administratorView);
        }
        else if(currentView instanceof RegisterStaffView)
        {
            AdministratorView administratorView = new AdministratorView(((RegisterStaffView)currentView).getStage());
            return new AdministratorController(person,administratorView);
        }
        else if(currentView instanceof SupplyBooksView)
        {
            if(person instanceof Administrator)
            {
                AdministratorView administratorView = new AdministratorView(((SupplyBooksView)currentView).getStage());
                return new AdministratorController(person,administratorView);
            }
            else if(person instanceof Manager)
            {
                ManagerView managerView = new ManagerView(((SupplyBooksView)currentView).getStage());
                return new ManagerController(person,managerView);
            }
        }
        else if(currentView instanceof AddToStockView)
        {
            if(person instanceof Administrator)
            {
                AdministratorView administratorView = new AdministratorView(((AddToStockView)currentView).getStage());
                return new AdministratorController(person,administratorView);
            }
            else if(person instanceof Manager)
            {
                ManagerView managerView = new ManagerView(((AddToStockView)currentView).getStage());
                return new ManagerController(person,managerView);
            }
        }
        else if(currentView instanceof AddCategoryView)
        {
            if(person instanceof Administrator)
            {
                AdministratorView administratorView = new AdministratorView(((AddCategoryView)currentView).getStage());
                return new AdministratorController(person,administratorView);
            }
            else if(person instanceof Manager)
            {
                ManagerView managerView = new ManagerView(((AddCategoryView)currentView).getStage());
               return new ManagerController(person,managerView);
            }
        }
        return null;
    }
}
