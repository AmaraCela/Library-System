package Controllers;

import Views.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.Manager;
import models.Person;
import models.Controller;

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
            if(!((Manager)person).isAddBooks())
            {
               label.setVisible(true);
            }
            else {
                SupplyBooksView supplyBooksView = new SupplyBooksView(managerView.getStage());
                new SupplyBooksController(person,supplyBooksView);
            }

        });
        this.managerView.getManageCategoriesItem().setOnAction(e->
        {
            label.setVisible(false);
            if(!((Manager)person).isManageCategories())
            {
                label.setVisible(true);
            }
            else
            {
                AddCategoryView addCategoryView = new AddCategoryView(managerView.getStage());
                new CategoryController(person,addCategoryView);
            }

        });
        this.managerView.getManageBooksItem().setOnAction(e->
        {
            label.setVisible(false);
            ManageBooksView manageBooksView = new ManageBooksView(managerView.getStage(),2);
            new ManageBooksController(person,manageBooksView);

        });
        this.managerView.getLogOutItem().setOnAction(e->
        {

            LogInView logInView = new LogInView(managerView.getStage());
            new LogInController(logInView);
        });

        this.managerView.getAddToStockItem().setOnAction(e->
        {
            label.setVisible(false);
            if(!((Manager)person).isAddToStock())
            {
                label.setVisible(true);
            }
            else
            {
                AddToStockView addToStockView = new AddToStockView(managerView.getStage());
                new AddToStockController(person,addToStockView);
            }

        });
        this.managerView.getIncomesItem().setOnAction(e->
        {
            IncomesView incomesView = new IncomesView(this.managerView.getStage());
            new IncomesController(person,incomesView);
        });
    }
}
