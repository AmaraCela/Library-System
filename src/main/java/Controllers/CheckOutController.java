package Controllers;

import Views.CheckOutView;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class CheckOutController extends Controller //ok
{

    private CheckOutView checkOutView;
    List<Book> books;

    public CheckOutController(Person administrator, CheckOutView checkOutView, List<Book> selectedBooks) {
        this.books = selectedBooks;
        this.checkOutView = checkOutView;
        if(this.checkOutView.getBooks().size()==0)
        {
            this.checkOutView.getMustSelectLabel().setVisible(true);
            this.checkOutView.getProceedBt().setVisible(false);
            this.checkOutView.getLabel1().setVisible(false);
            this.checkOutView.getLabel2().setVisible(false);
        }
        else {

            this.checkOutView.getLabel1().setVisible(true);
            this.checkOutView.getLabel2().setVisible(true);
            this.checkOutView.getProceedBt().setVisible(true);
            this.checkOutView.getMustSelectLabel().setVisible(false);
        }

        this.checkOutView.getProceedBt().setOnAction(e ->
                {
                    this.checkOutView.getErrorLabel().setVisible(false);
                    this.checkOutView.getMustSelectLabel().setVisible(false);

                    ArrayList<Integer> quantities = getQuantities();

                    checkOutAction(quantities,administrator);
                }
        );
        this.checkOutView.getBackBt().setOnAction(e ->
        {
            this.goBack(checkOutView,administrator);
        });
    }

    public CheckOutController(List<Book> selectedBooks){
        this.books = selectedBooks;
    }

    public boolean validateCheckOut(List<Book> book, ArrayList<Integer> quantity) {

        for (int i = 0; i < book.size(); i++) {

            if (quantity.get(i) > book.get(i).getStock()) {

                return false;
            }
            if (quantity.get(i) <= 0) {
                return false;
            }
        }
        return true;
    }
    public Bill checkOutAction(ArrayList<Integer> quantities, Person administrator)
    {
        Bill bill = null;
        if (validateCheckOut(books, quantities)) {

            bill = new Bill(books, quantities);
            this.checkOutView.getSuccess().setText("The total is "+bill.CalculateTotal());
            if(administrator instanceof Librarian)
            {
                librarianCheckOut(administrator,bill,quantities);

            }
            decreaseStockOfItems(quantities);
        }
        else
        {
            this.checkOutView.getErrorLabel().setVisible(true);
        }
        return bill;
    }

    public Person librarianCheckOut(Person librarian, Bill bill, ArrayList<Integer> quantities)
    {
        ((Librarian) librarian).setNumberOfBills(1);
        ((Librarian) librarian).setPersonalRevenue(bill.CalculateTotal());
        int num = 0;
        for (int i =0;i< quantities.size();i++)
        {
            num+= quantities.get(i);
        }
        ((Librarian) librarian).setNumOfBooksSold(num);
        return librarian;
    }

    public List<Book> decreaseStockOfItems(ArrayList<Integer> quantities)
    {
        for (int i=0;i<books.size();i++) {
//            List<Book> books = category.readBooks();
//            for (int j = 0; j < books.size(); j++) {
//            this.checkOutView.getBooks().get(i).getCategory().getBookOfCategory(this.checkOutView.getBooks().get(i).getISBN()).decreaseStock(quantities.get(i));
//            this.checkOutView.getBooks().get(i).getCategory().updateBinaryFile();
//            books.get(i).getCategory().getBookOfCategory(books.get(i).getISBN()).decreaseStock(quantities.get(i));
            books.get(i).decreaseStock(quantities.get(i));
            books.get(i).getCategory().updateBooksOfCategory(i, books.get(i));
            books.get(i).getCategory().updateBinaryFile();
//            (books.get(i).getCategory()).updateBinaryFile();
//            }
//            category.updateBinaryFile();
        }

//        return this.checkOutView.getBooks();
        return books;
    }


    public ArrayList<Integer> getQuantities()
    {
        ArrayList<Integer> quantities = new ArrayList<>();
        for (int i = 0; i < this.checkOutView.getTextFields().size(); i++) {
            try {
                quantities.add(Integer.parseInt(this.checkOutView.getTextFields().get(i).getText()));
            }
            catch (NumberFormatException ex) {
                this.checkOutView.getErrorLabel().setVisible(true);
                quantities.add(-1);
            }

        }
        return quantities;
    }
}