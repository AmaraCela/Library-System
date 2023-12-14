package Controllers;

import Views.AddToStockView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import models.Book;
import models.Controller;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class AddToStockController extends Controller//ok
{

    private BorderPane addToStockView;

    public AddToStockController(Person person, BorderPane addToStockView)
    {
        this.addToStockView = addToStockView;

        ((AddToStockView) this.addToStockView).getPageBt().setOnAction(e->
        {
            this.goBack(addToStockView,person);
        });

        ((AddToStockView) this.addToStockView).getAddBt().setOnAction(e->
        {
            ((AddToStockView) this.addToStockView).getLabel2().setVisible(false);
            ((AddToStockView) this.addToStockView).getUnSuccessfulLabel().setVisible(false);
            ObservableList <Book> selectedBooks = ((AddToStockView) this.addToStockView).getBookTableView().getSelectionModel().getSelectedItems();

            if(selectedBooks.size()==0)
            {
               ((AddToStockView) this.addToStockView).getLabel2().setVisible(true);
            }

            else
            {
                returnBookToDisplay(selectedBooks);

            }

        });

    }

    public AddToStockController(){

    }

    public ArrayList<Book> returnBookToDisplay(ObservableList <Book> selectedBooks){
        int stock;
        try {
            stock = Integer.parseInt(((AddToStockView) this.addToStockView).getCopiesTf().getText());
            if(!validateStock(selectedBooks,stock))
            {
                ((AddToStockView) this.addToStockView).getUnSuccessfulLabel().setVisible(true);
                ((AddToStockView) this.addToStockView).getCopiesTf().clear();
            }
            else
            {

                ((AddToStockView) this.addToStockView).getBookTableView().getItems().clear();
                ((AddToStockView) this.addToStockView).getBooks().clear();


                ((AddToStockView) this.addToStockView).getBooks().addAll(addToBookList());

                ((AddToStockView) this.addToStockView).getBookTableView().getItems().addAll(FXCollections.observableList(((AddToStockView) this.addToStockView).getBooks()));
            }
        }
        catch (NumberFormatException ex)
        {
            ((AddToStockView) this.addToStockView).getUnSuccessfulLabel().setVisible(true);
            ((AddToStockView) this.addToStockView).getCopiesTf().clear();
        }
        return ((AddToStockView) this.addToStockView).getBooks();
    }

    public ArrayList<Book> addToBookList(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i< CategoryController.getCategories().size(); i++)
        {
            books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }
        return books;
    }

    public boolean validateStock(List<Book> books, int stock)
    {
        if(stock<=0)
        {
            return false;
        }
        else
        {
            books.get(0).getCategory().getBookOfCategory(books.get(0).getISBN()).increaseStock(stock);
            return true;
        }

    }
}
