package Controllers;

import Views.AdministratorView;
import Views.LibrarianView;
import Views.LogInView;
import Views.ManagerView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.*;

public class LogInController extends Controller {

    private final LogInView logInView;
    private Person person=null;

    public LogInController(LogInView logInView)
    {
        this.logInView = logInView;

        logInView.getLogInBt().setOnAction(e->
                {
                    String username = this.logInView.getUsernameTf().getText();
                    String password = this.logInView.getPasswordTf().getText();
                    login(username,password);

                }
        );
    }

    public void login(String username, String password)
    {
        RegisterStaffController.readFromFile();
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeee");
        person = RegisterStaffController.isAccount(username, password);
        if (person == null) {
            Text text = new Text("Enter a valid username and password!");
            text.setFill(Color.rgb(175,10,43));
            text.setFont(Font.font("Bookman Old Style", FontWeight.BOLD,15));

            this.logInView.getUsernameTf().clear();
            this.logInView.getPasswordTf().clear();
            this.logInView.getGridPane().add(text,1,3);
            System.out.println("NULLLLLLLLLLLLLLL");
            LogInView.loginFailed.setVisible(true);
        }
        else
        {
            if(person instanceof Administrator)
            {
                AdministratorView administratorView= new AdministratorView(this.logInView.getStage());
                new AdministratorController(person,administratorView);
                person.personnelData();
                System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEE");
            }
            else if(person instanceof Manager)
            {
                ManagerView managerView = new ManagerView(this.logInView.getStage());
                new ManagerController(person,managerView);
                person.personnelData();
            }
            else if(person instanceof Librarian)
            {
                LibrarianView librarianView = new LibrarianView(this.logInView.getStage());
                new LibrarianController(person,librarianView);
                person.personnelData();
            }
            LogInView.loginSuccessful.setVisible(true);
            System.out.println(LogInView.loginSuccessful);
        }
    }


}
