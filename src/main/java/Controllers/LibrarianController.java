package Controllers;

import Views.LibrarianView;
import Views.LogInView;
import Views.ManageBooksView;
import models.Person;

public class LibrarianController {

    private final LibrarianView librarianView;

    public LibrarianController(Person librarian, LibrarianView librarianView)
    {
     this.librarianView = librarianView;

     this.librarianView.getViewBooksItem().setOnAction(e->
     {
         ManageBooksView manageBooksView = new ManageBooksView(librarianView.getStage(),1);
         new ManageBooksController(librarian,manageBooksView);
     });
     this.librarianView.getLogOutItem().setOnAction(e->
     {
         LogInView logInView = new LogInView(librarianView.getStage());
         new LogInController(logInView);
     });
    }

}
