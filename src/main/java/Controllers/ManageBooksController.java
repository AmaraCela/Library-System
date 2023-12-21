package Controllers;

import Views.CheckOutView;
import Views.LibrarianView;
import Views.ManageBooksView;
import Views.ManagerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.util.List;

public class ManageBooksController extends Controller //ok
{

    private final ManageBooksView manageBooksView;

    public ManageBooksController(Person person, ManageBooksView manageBooksView)
    {
        this.manageBooksView = manageBooksView;

        this.manageBooksView.getCheckOutBt().setVisible(false);
        this.manageBooksView.getDeleteBt().setVisible(false);
        if(person instanceof Administrator)
        {
            this.manageBooksView.getCheckOutBt().setVisible(true);
            this.manageBooksView.getSelectBt().setVisible(false);
            this.manageBooksView.getDeleteBt().setVisible(true);
        }
        else if (person instanceof Librarian)
        {
            this.manageBooksView.getCheckOutBt().setVisible(true);
            this.manageBooksView.getSelectBt().setVisible(false);
            this.manageBooksView.getDeleteBt().setVisible(false);
        }
        else
        {
            this.manageBooksView.getDeleteBt().setVisible(true);
            this.manageBooksView.getCheckOutBt().setVisible(false);
            this.manageBooksView.getSelectBt().setVisible(false);
        }
        this.manageBooksView.getFilterByCategoryBt().setOnAction(e->
        {
            this.manageBooksView.getFilterByCategoryBt().setVisible(false);
            this.manageBooksView.getSelectBt().setVisible(true);
            for (int l = 0;l<this.manageBooksView.getCheckBoxes().size();l++)
            {
                this.manageBooksView.getCheckBoxes().get(l).setVisible(true);


            }
        });

        this.manageBooksView.getSelectBt().setOnAction(e->
        {
            this.manageBooksView.getBooks().clear();
            this.manageBooksView.getTableView().getItems().clear();

            for(int i = 0; i<this.manageBooksView.getCheckBoxes().size();i++)
            {
                if(this.manageBooksView.getCheckBoxes().get(i).isSelected())
                {

                    this.manageBooksView.getBooks().addAll(CategoryController.getCategories().get(i).getBooksOfCategory());

                }
            }
            this.manageBooksView.getTableView().getItems().addAll(FXCollections.observableList(this.manageBooksView.getBooks()));


        });

        this.manageBooksView.getDeleteBt().setOnAction(e->
        {

            List<Book> selectedBooks = this.manageBooksView.getTableView().getSelectionModel().getSelectedItems();

            for (int i=0;i<selectedBooks.size();i++)
            {
                selectedBooks.get(i).getCategory().getBooksOfCategory().remove(selectedBooks.get(i));
                selectedBooks.get(i).getCategory().updateBinaryFile();

            }
            this.manageBooksView.updateBooks();

            this.manageBooksView.getTableView().getItems().clear();
            this.manageBooksView.getTableView().getItems().addAll(this.manageBooksView.getBooks());


        });

        this.manageBooksView.getCheckOutBt().setOnAction(e->
        {
            ObservableList<Book> selectedBooks = this.manageBooksView.getTableView().getSelectionModel().getSelectedItems();
            CheckOutView checkOutView = new CheckOutView(this.manageBooksView.getStage(),selectedBooks);

            new CheckOutController(person,checkOutView);
        });

        this.manageBooksView.getLibrarianPageBt().setOnAction(e->
        {
            LibrarianView librarianView = new LibrarianView(this.manageBooksView.getStage());
            new LibrarianController(person,librarianView);
        });

        this.manageBooksView.getManagerPageBt().setOnAction(e->
        {
            ManagerView managerView = new ManagerView(this.manageBooksView.getStage());
            new ManagerController(person,managerView);
        });
        this.manageBooksView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(manageBooksView,person);
        });
    }

//    public List<Book> removeBooks(List<Book> selectedBooks, Category category){
//        for (int i=0;i<selectedBooks.size();i++)
//        {
//            selectedBooks.get(i).getCategory().getBooksOfCategory().remove(selectedBooks.get(i));
//            selectedBooks.get(i).getCategory().updateBinaryFile();
//        }
//        return category.readBooks();
//    }

}
