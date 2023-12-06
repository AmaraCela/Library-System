package Controllers;

import Views.IncomesView;
import models.Person;
import models.Controller;

public class IncomesController extends Controller //ok
{

    private final IncomesView incomesView;
    public IncomesController(Person person, IncomesView incomesView)
    {
        this.incomesView = incomesView;
        this.incomesView.getBackBt().setOnAction(e->
        {
            this.goBack(incomesView,person);
        });
    }
}
