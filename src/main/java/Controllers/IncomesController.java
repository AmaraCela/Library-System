package Controllers;

import Views.IncomesView;
import Views.ManagerView;
import models.Person;

public class IncomesController {

    private final IncomesView incomesView;
    public IncomesController(Person person, IncomesView incomesView)
    {
        this.incomesView = incomesView;
        this.incomesView.getBackBt().setOnAction(e->
        {
            ManagerView managerView = new ManagerView(incomesView.getStage());
            new ManagerController(person,managerView);
        });
    }
}
