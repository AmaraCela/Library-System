package Views;

import Controllers.RegisterStaffController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Manager;
import models.Person;

import java.util.ArrayList;

public class AddBooksPermissionView extends BorderPane{

    private final Stage stage;
    private final ArrayList<CheckBox> checkBoxes1 = new ArrayList<>();
    private final ArrayList<CheckBox> checkBoxes2 = new ArrayList<>();


    private final Button proceedBt = new Button("Proceed");
    private final Button administratorPageBt = new Button();

    private final ArrayList<Person> managers1 = new ArrayList<>();
    private final ArrayList<Person> managers2 = new ArrayList<>();
    public AddBooksPermissionView(Stage stage)
    {
        this.stage = stage;

        for(int i = 0; i< RegisterStaffController.getManagers().size(); i++)
        {
            if(((Manager)RegisterStaffController.getManagers().get(i)).isAddBooks())
            {
                managers1.add(RegisterStaffController.getManagers().get(i));
            }
            else
            {
                managers2.add(RegisterStaffController.getManagers().get(i));
            }
        }

        Text revokeAddBooks = new Text("Revoke the permission of adding books: ");
        Text allowAddBooks = new Text("Allow the permission of adding books: ");

        revokeAddBooks.setFont(Font.font("Arial Rounded MT Bold",12));
        allowAddBooks.setFont(Font.font("Arial Rounded MT Bold",12));

        revokeAddBooks.setFill(Color.DARKBLUE);
        allowAddBooks.setFill(Color.DARKBLUE);

        GridPane gridPane = new GridPane();
        gridPane.add(revokeAddBooks,0,0);
        gridPane.add(allowAddBooks,1,0);

        gridPane.setAlignment(Pos.CENTER);
        int i;
        for(i = 0;i<managers1.size();i++)
        {
            checkBoxes1.add(new CheckBox(managers1.get(i).getName()));
            gridPane.add(checkBoxes1.get(i),0,i+1);
        }
        int j;
        for(j = 0;j<managers2.size();j++)
        {
            checkBoxes2.add(new CheckBox(managers2.get(i).getName()));
            gridPane.add(checkBoxes2.get(i),1,j+1);
        }

        gridPane.add(proceedBt,1,i+j+1);
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        administratorPageBt.setGraphic(new ImageView("file:go-back-2.png"));
        administratorPageBt.setPrefSize(10,10);
        administratorPageBt.setAlignment(Pos.TOP_LEFT);
        this.setTop(administratorPageBt);
        this.setCenter(gridPane);

        Scene scene = new Scene(this,1000,600);
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public ArrayList<CheckBox> getCheckBoxes1() {
        return checkBoxes1;
    }

    public ArrayList<CheckBox> getCheckBoxes2() {
        return checkBoxes2;
    }

    public Button getProceedBt() {
        return proceedBt;
    }

    public Button getAdministratorPageBt() {
        return administratorPageBt;
    }

    public ArrayList<Person> getManagers1() {
        return managers1;
    }

    public ArrayList<Person> getManagers2() {
        return managers2;
    }
}
