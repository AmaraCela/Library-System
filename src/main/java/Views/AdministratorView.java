package Views;

import Controllers.RegisterStaffController;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.*;

public class AdministratorView extends BorderPane {

    private final Stage stage;
    private final MenuBar menuBar = new MenuBar();
    private final Menu addEmployees = new Menu("Register");

    private final Menu updateEmployees = new Menu("Modify");
    private  Menu viewEmployees = new Menu("Delete");

    private Menu addCategories = new Menu("Categories");
    private  Menu supplyBooks = new Menu("Books");
    private  Menu permissions = new Menu("Permissions");
    private Menu logoutMenu = new Menu("Log out");
    private MenuItem registerLibrarian = new MenuItem("Register Librarian");
   private MenuItem registerManager = new MenuItem("Register Manager");
   private MenuItem modifyLibrarian = new MenuItem("Modify Librarian");
   private MenuItem modifyManager = new MenuItem("Modify Manager");

   private MenuItem viewLibrarian = new MenuItem("Delete Librarians");
   private MenuItem viewManager = new MenuItem("Delete managers");
   private MenuItem addBookCatgory = new MenuItem("Manage categories");

   private MenuItem viewBooks = new MenuItem("View Books");
   private MenuItem supplyBooksItem = new MenuItem("Supply Books");
   private  MenuItem addStockItem = new MenuItem("Add to stock");
   private  MenuItem permissionsLibrarianItem = new MenuItem("Librarian Permissions");
   private MenuItem permissionsManagerItem = new MenuItem("Manager permissions");
   private MenuItem logOutItem = new MenuItem("Log out");
    public AdministratorView(Stage stage)
    {
     this.stage = stage;

        menuBar.prefWidthProperty().bind(this.widthProperty());
        menuBar.setStyle("-fx-padding: 5 10 8 10;");

        addEmployees.getItems().addAll(registerLibrarian,registerManager);


        updateEmployees.getItems().addAll(modifyLibrarian,modifyManager);


        viewEmployees.getItems().addAll(viewLibrarian,viewManager);




        addCategories.getItems().add(addBookCatgory);


        supplyBooks.getItems().addAll(supplyBooksItem,viewBooks,addStockItem);





        permissions.getItems().addAll(permissionsLibrarianItem,permissionsManagerItem);



        logoutMenu.getItems().add(logOutItem);


        menuBar.getMenus().addAll(addEmployees,updateEmployees,viewEmployees,addCategories,supplyBooks,permissions,logoutMenu);

        HBox hBox = new HBox(10);
        hBox.getChildren().add(menuBar);
        this.setTop(hBox);

        Text incomesText = new Text("Welcome to the administrator page!\n\nStatistics:\nThe total incomes from the books sold are: "+Bill.getRevenues("revenues.txt")+"\nThe total costs of the library are: "+(RegisterStaffController.getEmployeesCost()+ Book.getTotalCost()));
        System.out.println("Book controller.bookCost = " +Book.getTotalCost());

        incomesText.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD,20));
        incomesText.setFill(Color.DARKBLUE);
        incomesText.setStroke(Color.LIGHTBLUE);
         this.setCenter(incomesText);

        Scene scene = new Scene(this,1000,600);
       stage.setScene(scene);
    }

   public Stage getStage() {
      return stage;
   }

   public MenuBar getMenuBar() {
      return menuBar;
   }

   public Menu getAddEmployees() {
      return addEmployees;
   }


   public Menu getUpdateEmployees() {
      return updateEmployees;
   }

   public Menu getViewEmployees() {
      return viewEmployees;
   }


   public Menu getAddCategories() {
      return addCategories;
   }

   public Menu getSupplyBooks() {
      return supplyBooks;
   }

   public Menu getPermissions() {
      return permissions;
   }

   public Menu getLogoutMenu() {
      return logoutMenu;
   }

   public MenuItem getRegisterLibrarian() {
      return registerLibrarian;
   }

   public MenuItem getRegisterManager() {
      return registerManager;
   }


   public MenuItem getModifyLibrarian() {
      return modifyLibrarian;
   }

   public MenuItem getModifyManager() {
      return modifyManager;
   }

   public MenuItem getViewLibrarian() {
      return viewLibrarian;
   }

   public MenuItem getViewManager() {
      return viewManager;
   }

   public MenuItem getAddBookCatgory() {
      return addBookCatgory;
   }

   public MenuItem getViewBooks() {
      return viewBooks;
   }

   public MenuItem getSupplyBooksItem() {
      return supplyBooksItem;
   }

   public MenuItem getAddStockItem() {
      return addStockItem;
   }



   public MenuItem getPermissionsLibrarianItem() {
      return permissionsLibrarianItem;
   }

   public MenuItem getPermissionsManagerItem() {
      return permissionsManagerItem;
   }

   public MenuItem getLogOutItem() {
      return logOutItem;
   }
}
