package Controllers;

import Views.CheckOutView;
import Views.ManageBooksView;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import models.*;

import java.util.ArrayList;

public class CheckOutController {

    private final CheckOutView checkOutView;

    public CheckOutController(Person administrator, CheckOutView checkOutView) {
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
            checkOut(administrator);
        }
        );
        this.checkOutView.getBackBt().setOnAction(e ->
        {
            ManageBooksView manageBooksView ;
            if (administrator instanceof Librarian) {
                manageBooksView = new ManageBooksView(this.checkOutView.getStage(),1);
            } else if (administrator instanceof Manager) {
                manageBooksView = new ManageBooksView(this.checkOutView.getStage(),2);
            } else {
                manageBooksView = new ManageBooksView(this.checkOutView.getStage(),3);
            }

            new ManageBooksController(administrator, manageBooksView);
        });
    }

    public boolean validateCheckOut(ObservableList<Book> book, ArrayList<Integer> quantity) {

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

    public void checkOut(Person administrator)
    {

        this.checkOutView.getErrorLabel().setVisible(false);
        this.checkOutView.getMustSelectLabel().setVisible(false);

        ArrayList<Integer> quantities = getQuantities();

        checkOutAction(quantities,administrator);
    }


    public Bill checkOutAction(ArrayList<Integer> quantities, Person administrator)
    {
        Bill bill = null;
        if (validateCheckOut(this.checkOutView.getBooks(), quantities)) {

            bill = new Bill(this.checkOutView.getBooks(), quantities);
            Text text = new Text("The total is "+ bill.getTotal());
            text.setFont(Font.font("Arial Rounded MT Bold",12));
            text.setFill(Color.DARKBLUE);
            this.checkOutView.getGridPane().add(text,4,4);
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

    public Person librarianCheckOut(Person administrator, Bill bill, ArrayList<Integer> quantities)
    {
        ((Librarian) administrator).setNumberOfBills();
        ((Librarian) administrator).setPersonalRevenue(bill.getTotal());
        int num = 0;
        for (int i =0;i< quantities.size();i++)
        {
            num+= quantities.get(i);
        }
        ((Librarian) administrator).setNumOfBooksSold(num);
        return administrator;
    }

    public ObservableList<Book> decreaseStockOfItems(ArrayList<Integer> quantities)
    {
        for (int i=0;i<this.checkOutView.getBooks().size();i++)
        {
            this.checkOutView.getBooks().get(i).getCategory().getBookOfCategory(this.checkOutView.getBooks().get(i).getISBN()).decreaseStock(quantities.get(i));
            this.checkOutView.getBooks().get(i).getCategory().updateBinaryFile();

        }

        return this.checkOutView.getBooks();

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