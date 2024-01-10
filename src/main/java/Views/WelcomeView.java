package Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WelcomeView extends BorderPane {
    Button enterBt = new Button("Enter");

   public WelcomeView ()
   {
       StackPane stackPaneTop = new StackPane();

       stackPaneTop.setPadding(new Insets(20,5,5,5));
       Label welcomeText = new Label("Welcome to the library system!");
       welcomeText.setLayoutX(150);
       welcomeText.setLayoutY(154);
       welcomeText.setTextFill(Color.rgb(10,10,140));
       welcomeText.setFont (Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD,20));
       stackPaneTop.getChildren().add(welcomeText);
       this.setTop(stackPaneTop);



       StackPane stackPaneCenter = new StackPane();
       Rectangle rectangle = new Rectangle(500,300);
       Rectangle rectangle1  = new Rectangle(490,320);
       rectangle1.setFill(Color.rgb(67,179,189));
       rectangle1.setStroke(Color.DARKBLUE);
       rectangle.setStroke(Color.DARKBLUE);
       rectangle.setFill(Color.rgb(210,244,244));
       rectangle.xProperty().bind(this.widthProperty().divide(2));
       stackPaneCenter.getChildren().add(rectangle);
       rectangle.toBack();
       stackPaneCenter.getChildren().add(rectangle1);
       rectangle1.toBack();



       enterBt.setLayoutY(200);
       enterBt.setLayoutX(200);
       enterBt.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD,10));
       enterBt.setTextFill(Color.rgb(20,20,110));
       enterBt.setGraphic(new ImageView("file:enterbt1.png"));
       stackPaneCenter.getChildren().add(enterBt);

       this.setCenter(stackPaneCenter);

   }

    public Button getEnterBt() {
        return enterBt;
    }

    public static class ClickPane extends BorderPane
    {
         public ClickPane()
         {
             Button enterBt = new Button("Enter");
             getChildren().add(enterBt);
         }
    }
}
