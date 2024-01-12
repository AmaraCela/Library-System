package Controllers;

import Views.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.Controller;
import models.Person;

public class ManagerController extends Controller {

    private final ManagerView managerView;

    public ManagerController(Person person, ManagerView managerView)
    {
        this.managerView = managerView;

        Label label = new Label("You do not have permission to perform this action");
        label.setTextFill(Color.DARKRED);
        label.setFont(Font.font("Arial Rounded MT Bold",14));
        label.setVisible(false);
        label.setAlignment(Pos.CENTER);
        this.managerView.setBottom(label);
        this.managerView.getSupplyBooksItem().setOnAction(e->
        {
            label.setVisible(false);

                SupplyBooksView supplyBooksView = new SupplyBooksView(managerView.getStage(), person);
//                new SupplyBooksController(person,supplyBooksView);

        });
        this.managerView.getManageCategoriesItem().setOnAction(e->
        {
            label.setVisible(false);

                AddCategoryView addCategoryView = new AddCategoryView(person, managerView.getStage());
//                new CategoryController(person,addCategoryView);


        });
        this.managerView.getManageBooksItem().setOnAction(e->
        {
            label.setVisible(false);
            ManageBooksView manageBooksView = new ManageBooksView(person,managerView.getStage(),2);
//            new ManageBooksController(person,manageBooksView);

        });
        this.managerView.getLogOutItem().setOnAction(e->
        {

            LogInView logInView = new LogInView(managerView.getStage());
            new LogInController(logInView);
        });

        this.managerView.getAddToStockItem().setOnAction(e->
        {
            label.setVisible(false);

                AddToStockView addToStockView = new AddToStockView(person,managerView.getStage());
//                new AddToStockController(person,addToStockView);

        });
        this.managerView.getIncomesItem().setOnAction(e->
        {
            IncomesView incomesView = new IncomesView(this.managerView.getStage());
            new IncomesController(person,incomesView);
        });
    }
}
