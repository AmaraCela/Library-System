package Controllers;

import Views.AddToStockView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Book;
import models.Person;
import models.Controller;

public class AddToStockController extends Controller//ok
{

    private final AddToStockView addToStockView;

    public AddToStockController(Person person, AddToStockView addToStockView)
    {
        this.addToStockView = addToStockView;

        this.addToStockView.getPageBt().setOnAction(e->
        {
            this.goBack(addToStockView,person);
        });

        this.addToStockView.getAddBt().setOnAction(e->
        {
            this.addToStockView.getLabel2().setVisible(false);
            this.addToStockView.getUnSuccessfulLabel().setVisible(false);
            ObservableList <Book> selectedBooks = this.addToStockView.getBookTableView().getSelectionModel().getSelectedItems();

            if(selectedBooks.size()==0)
            {
               this.addToStockView.getLabel2().setVisible(true);
            }

            else
            {
                int stock;
                try {
                    stock = Integer.parseInt(this.addToStockView.getCopiesTf().getText());
                    if(!validateStock(selectedBooks,stock))
                    {
                        this.addToStockView.getUnSuccessfulLabel().setVisible(true);
                        this.addToStockView.getCopiesTf().clear();

                    }
                    else
                    {

                        this.addToStockView.getBookTableView().getItems().clear();
                        this.addToStockView.getBooks().clear();
                        for (int i = 0; i< CategoryController.getCategories().size(); i++)
                        {
                            this.addToStockView.getBooks().addAll(CategoryController.getCategories().get(i).getBooksOfCategory());


                        }
                        this.addToStockView.getBookTableView().getItems().addAll(FXCollections.observableList(this.addToStockView.getBooks()));
                    }
                }
                catch (NumberFormatException ex)
                {
                    this.addToStockView.getUnSuccessfulLabel().setVisible(true);
                    this.addToStockView.getCopiesTf().clear();
                }

            }

        });

    }

    public boolean validateStock(ObservableList<Book> books,int stock)
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
