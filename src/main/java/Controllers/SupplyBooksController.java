package Controllers;

import Views.SupplyBooksView;
import javafx.collections.FXCollections;
import models.Book;
import models.Category;
import models.Person;
import models.Controller;

import java.util.ArrayList;
import java.util.Objects;

public class SupplyBooksController extends Controller //ok
{
    private SupplyBooksView supplyBooksView;
    private ArrayList<Book> books;

    public SupplyBooksController(Person administrator, SupplyBooksView supplyBooksView)
    {
        books= new ArrayList<>();
        this.supplyBooksView = supplyBooksView;
        addBooks();
        this.supplyBooksView.getAdministratorPageBt().setOnAction(e->
        {
            this.goBack(supplyBooksView,administrator);

        });


            this.supplyBooksView.getAddCategoryBt().setOnAction(e->
            {
                this.supplyBooksView.getTextISBN().setVisible(false);
                this.supplyBooksView.getTextTitle().setVisible(false);
                this.supplyBooksView.getTextAuthor().setVisible(false);
                this.supplyBooksView.getTextPrice().setVisible(false);
                this.supplyBooksView.getTextOriginalPrice().setVisible(false);
                this.supplyBooksView.getTextStock().setVisible(false);
                this.supplyBooksView.getTextSupplier().setVisible(false);
                this.supplyBooksView.getTextSuccessful().setVisible(false);
                String categoryName = this.supplyBooksView.getCategoryTf().getText();

                if(CategoryController.getCategories().size()==0) {
                    if(categoryName.length()==0)
                    {
                        this.supplyBooksView.getTextInvalidCategory().setVisible(true);
                    }
                    else
                    {
                        CategoryController.addCategory(new Category(categoryName));
                        this.supplyBooksView.getCategoryCB().getItems().addAll(FXCollections.observableList(CategoryController.getCategoryNames()));
                        this.supplyBooksView.getCategoryTf().setVisible(false);
                        this.supplyBooksView.getAddCategoryBt().setVisible(false);
                        this.supplyBooksView.getCategoryCB().setVisible(true);
                        this.supplyBooksView.getAddBt().setVisible(true);
                        this.supplyBooksView.getLabel().setVisible(false);
                    }
                }


            });


        this.supplyBooksView.getAddBt().setOnAction(e->
         {
                this.supplyBooksView.getTextISBN().setVisible(false);
                this.supplyBooksView.getTextTitle().setVisible(false);
                this.supplyBooksView.getTextAuthor().setVisible(false);
                this.supplyBooksView.getTextPrice().setVisible(false);
                this.supplyBooksView.getTextOriginalPrice().setVisible(false);
                this.supplyBooksView.getTextStock().setVisible(false);
                this.supplyBooksView.getTextSupplier().setVisible(false);
                this.supplyBooksView.getLabel().setVisible(false);
                this.supplyBooksView.getTextSuccessful().setVisible(false);
                this.supplyBooksView.getTextCategory().setVisible(false);
                String ISBN = this.supplyBooksView.getISBNTf().getText();
                boolean validatedISBN = validateISBN(ISBN);
                if(!validatedISBN)
                {
                    this.supplyBooksView.getTextISBN().setVisible(true);
                }

                String title = this.supplyBooksView.getTitleTf().getText();
                boolean validatedTitle = validateTitle(title);
                if(!validatedTitle)
                {
                    this.supplyBooksView.getTextTitle().setVisible(true);
                }
                String author = this.supplyBooksView.getAuthorTf().getText();
                boolean validatedAuthor = validateAuthor(author);
                if(!validatedAuthor)
                {
                    this.supplyBooksView.getTextAuthor().setVisible(true);
                }
             boolean validatedPurchasePrice = false;
             double purchasePrice = 0;
             try{
                     purchasePrice = Double.parseDouble(this.supplyBooksView.getPurchasedPriceTf().getText());
                     validatedPurchasePrice = validatePurchasePrice(purchasePrice);
                    if(!validatedPurchasePrice)
                    {
                        this.supplyBooksView.getTextPrice().setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    this.supplyBooksView.getTextPrice().setVisible(true);
                }
             boolean validatedOriginalPrice = false;
             double originalPrice = 0;
             try {
                     originalPrice = Double.parseDouble(this.supplyBooksView.getOriginalPriceTf().getText());
                    validatedOriginalPrice = validateOriginalPrice(originalPrice);
                    if(!validatedOriginalPrice)
                    {
                        this.supplyBooksView.getTextOriginalPrice().setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    this.supplyBooksView.getTextOriginalPrice().setVisible(true);
                }

             boolean validatedSellingPrice = false;
             double sellingPrice = 0;
                try{
                     sellingPrice = Double.parseDouble(this.supplyBooksView.getSellingPriceTf().getText());
                     validatedSellingPrice = validateSellingPrice(sellingPrice);
                    if(!validatedSellingPrice)
                    {
                        this.supplyBooksView.getTextSellingPrice().setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    this.supplyBooksView.getTextSellingPrice().setVisible(true);
                }

                String supplier = this.supplyBooksView.getSupplierTf().getText();

                boolean validatedSupplier = validateSupplier(supplier);
                if(!validatedSupplier)
                {
                    this.supplyBooksView.getTextSupplier().setVisible(true);
                }
                boolean validatedStock = false;
                int stock = 0;
             try{
                     stock = Integer.parseInt(this.supplyBooksView.getStockTf().getText());
                     validatedStock = validateStock(stock);
                    if(!validatedStock)
                    {
                        this.supplyBooksView.getTextStock().setVisible(true);
                    }
                }
                catch (NumberFormatException ex)
                {
                    this.supplyBooksView.getTextStock().setVisible(true);
                }
                String categoryName = this.supplyBooksView.getCategoryCB().getValue();
                System.out.println("category name:" + categoryName);
                boolean validatedCategory = validateCategory(categoryName);
                if(!validatedCategory)
                {
                    this.supplyBooksView.getTextCategory().setVisible(true);
                }

                if(validatedISBN && validatedAuthor && validatedSupplier && validatedTitle && validatedCategory && validatedStock && validatedOriginalPrice && validatedPurchasePrice && validatedSellingPrice)
                {
                    supply(ISBN,title,categoryName,supplier,purchasePrice,originalPrice,sellingPrice,author,stock);
                    this.supplyBooksView.getTextSuccessful().setVisible(true);

                }

            });


    }

    public SupplyBooksController(){
        books = new ArrayList<>();
    }
    public ArrayList<Book> addBooks(){
        for (int i = 0;i<CategoryController.getCategories().size();i++)
        {
            books.addAll(CategoryController.getCategories().get(i).getBooksOfCategory());
        }
        return books;
    }
    public boolean validateISBN (String ISBN)
    {
        if(ISBN.length() == 0)
        {
            return false;
        }
        for (int i = 0;i<books.size();i++)
        {
            if(books.get(i).getISBN().equals(ISBN))
            {
                return false;
            }
        }
        return true;
    }

    public boolean validateTitle(String title)
    {
        if(title.trim().length()==0 || title.length()>35)
        {
            return false;
        }
        return true;
    }

    public boolean validatePurchasePrice(double purchasePrice)
    {
        if(purchasePrice<0)
        {
            return false;
        }
        return true;
    }

    public boolean validateOriginalPrice(double purchasePrice)
    {
        if(purchasePrice<0)
        {
            return false;
        }
        return true;
    }
    public boolean validateSellingPrice(double purchasePrice)
    {
        if(purchasePrice<0)
        {
            return false;
        }
        return true;
    }
    public boolean validateSupplier(String supplier)
    {
        if(supplier.trim().length()==0 || supplier.length()>35)
        {

            return false;
        }
        return true;
    }

    public boolean validateStock(int stock)
    {
        if(stock<=0)
        {
            return false;
        }
        return true;
    }


    public boolean validateAuthor(String author)
    {
        if(author.length()==0)
        {
            return false;
        }
        return true;
    }

    public boolean validateCategory(String categoryName)
    {
        if(categoryName==null)
        {
            return false;
        }
        if(categoryName.length()==0)
        {
            return false;
        }
        for(int i = 0;i<CategoryController.getCategories().size();i++)
        {
            if(CategoryController.getCategories().get(i).getCategoryName().equals(categoryName))
            {
                return true;
            }
        }
        return true;
    }

    public ArrayList<Book> supply(String ISBN, String title, String categoryName, String supplier,  double purchasedPrice, double originalPrice, double sellingPrice, String author, int stock) {
        Book book = new Book(ISBN,title, Objects.requireNonNull(CategoryController.getCategory(categoryName)),supplier,purchasedPrice,originalPrice,sellingPrice,author,stock);
        Objects.requireNonNull(CategoryController.getCategory(categoryName)).addBookToCategory(book);
        books.add(book);
        return books;
    }

}
