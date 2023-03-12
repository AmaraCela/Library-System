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
import models.Librarian;
import models.Person;

import java.util.ArrayList;

public class PermissionsLibrarianView extends BorderPane {


    private final Stage stage;
    private final Text revokeText = new Text("Revoke check out permissions to: ");
    private final Text allowText = new Text("Allow check out permissions to: ");

    private final ArrayList<CheckBox> checkBoxes1 = new ArrayList<>();
    private final ArrayList<CheckBox> checkBoxes2 = new ArrayList<>();


    private final Button proceedBt = new Button("Proceed");
    private final Button administratorPageBt = new Button();

    private final ArrayList<Person> librarians1 = new ArrayList<>();
    private final ArrayList<Person> librarians2 = new ArrayList<>();
    public PermissionsLibrarianView(Stage stage)
    {

        revokeText.setFont(Font.font("Arial Rounded MT Bold",14));
        allowText.setFont(Font.font("Arial Rounded MT Bold",14));

        revokeText.setFill(Color.DARKBLUE);
        allowText.setFill(Color.DARKBLUE);

        GridPane gridPane = new GridPane();
        gridPane.add(revokeText,0,0);
        gridPane.add(allowText,1,0);

        this.stage = stage;

        for(int i=0;i< RegisterStaffController.getLibrarians().size();i++)
        {
            if(((Librarian)RegisterStaffController.getLibrarians().get(i)).isCheckOutPermission())
            {
                librarians1.add(RegisterStaffController.getLibrarians().get(i));

            }
            else
            {
                librarians2.add(RegisterStaffController.getLibrarians().get(i));
            }
        }
        int i;


        for( i = 0; i<librarians1.size();i++)
        {
            checkBoxes1.add(new CheckBox(librarians1.get(i).getName()));
            gridPane.add(checkBoxes1.get(i),0,i+1);
        }
        int j;
        for(j = 0; j<librarians2.size();j++)
        {
            checkBoxes2.add(new CheckBox(librarians2.get(j).getName()));
            gridPane.add(checkBoxes2.get(j),1,j+1);
        }
        gridPane.add(proceedBt,1,i+j+1);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);

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

    public Text getRevokeText() {
        return revokeText;
    }

    public Text getAllowText() {
        return allowText;
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

    public ArrayList<Person> getLibrarians1() {
        return librarians1;
    }

    public ArrayList<Person> getLibrarians2() {
        return librarians2;
    }
}
