package systemTest;

import Views.SupplyBooksView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupplyBooksViewTest extends ApplicationTest {

    Parent sceneRoot;
    Button administratorPageBt;
    Button addCategoryBt;
    Button addBt;
    TextField categoryTf;
    TextField ISBNTf;
    TextField titleTf;
    TextField supplierTf;
    TextField purchasedPriceTf;
    TextField originalPriceTf;
    TextField sellingPriceTf;
    TextField authorTf;
    TextField stockTf;
    Text textSuccessful;
    Text textISBN;
    Text textTitle;
    Text textSupplier;
    Text textPrice;
    Text textOriginalPrice;
    Text textSellingPrice;
    Text textStock;
    Text textCategory;
    Text textAuthor;

    Text textInvalidCategory;
    Label label;
    Label categoryLabel;
    ComboBox<String> categoryCB;
    public void start(Stage stage){
        sceneRoot = new SupplyBooksView.ClickPane();
        Scene scene = new Scene(sceneRoot, 700, 700);
        stage.setScene(scene);
        new SupplyBooksView(stage, new Manager("n","s","e","b","i","p",1,"1"));
        stage.show();
    }

    @BeforeEach
    void setUp(){
        addBt = lookup("#addBt").queryAs(Button.class);
        administratorPageBt = lookup("#administratorPageBt").queryAs(Button.class);
        categoryTf = lookup("#categoryTf").queryAs(TextField.class);

        ISBNTf = lookup("#ISBNTf").queryAs(TextField.class);
        titleTf = lookup("#titleTf").queryAs(TextField.class);
        supplierTf = lookup("#supplierTf").queryAs(TextField.class);
        purchasedPriceTf = lookup("#purchasedPriceTf").queryAs(TextField.class);
        originalPriceTf = lookup("#originalPriceTf").queryAs(TextField.class);
        sellingPriceTf = lookup("#sellingPriceTf").queryAs(TextField.class);
        authorTf = lookup("#authorTf").queryAs(TextField.class);
        stockTf = lookup("#stockTf").queryAs(TextField.class);
        textSuccessful = lookup("#textSuccessful").queryAs(Text.class);
        textISBN = lookup("#textISBN").queryAs(Text.class);
        textTitle = lookup("#textTitle").queryText();
        textSupplier = lookup("#textSupplier").queryText();
        textPrice = lookup("#textPrice").queryText();
        textOriginalPrice = lookup("#textOriginalPrice").queryText();
        textSellingPrice = lookup("#textSellingPrice").queryText();
        textStock = lookup("#textStock").queryText();
        textCategory = lookup("#textCategory").queryText();
        textAuthor = lookup("#textAuthor").queryText();

        textInvalidCategory = lookup("#textInvalidCategory").queryText();
        label = lookup("#label").queryAs(Label.class);
        categoryLabel = lookup("#categoryLabel").queryAs(Label.class);
        categoryCB = lookup("#categoryCB").queryComboBox();
        addCategoryBt = lookup("#addCategoryBt").queryAs(Button.class);

        SupplyBooksView.clearTextFields();
    }

    @AfterEach
    void dropDown(){
        File file = new File("categories.dat");
        file.delete();

    }
    
    @Order(2)
    @Test
    void test_addValidBook(){
       clickOn(ISBNTf).write("1111");
       clickOn(titleTf).write("Book1");
       clickOn(supplierTf).write("supplier1");
       clickOn(purchasedPriceTf).write("1200");
       clickOn(originalPriceTf).write("1000");
       clickOn(sellingPriceTf).write("1350");
       clickOn(authorTf).write("author1");
       clickOn(stockTf).write("2");
//       clickOn(categoryTf).write("Comedy");
//       clickOn(addCategoryBt);
//        clickOn(categoryCB.getItems().get(0));
        clickOn(categoryCB).clickOn(categoryCB.getItems().get(0));
//        System.out.println(categoryCB.getItems().get(0));
        clickOn(addBt);
        assertFalse(textISBN.isVisible());
        assertFalse(textTitle.isVisible());
        assertFalse(textAuthor.isVisible());
        assertFalse(textCategory.isVisible());
        assertFalse(textInvalidCategory.isVisible());
        assertFalse(textOriginalPrice.isVisible());
        assertFalse(textPrice.isVisible());
        assertFalse(textSellingPrice.isVisible());
        assertFalse(textStock.isVisible());
    }

    @Order(1)
    @Test
    void test_addInvalidBook(){
        clickOn(ISBNTf).write("");
        clickOn(titleTf).write("Book2");
        clickOn(supplierTf).write("supplier2");
        clickOn(purchasedPriceTf).write("1200");
        clickOn(originalPriceTf).write("1000");
        clickOn(sellingPriceTf).write("1350");
        clickOn(authorTf).write("author2");
        clickOn(stockTf).write("1");
        clickOn(categoryTf).write("Comedy");
        clickOn(addCategoryBt);
//        clickOn(categoryCB.getItems().get(0));
        System.out.println(categoryCB.getItems());
        clickOn(categoryCB).clickOn(categoryCB.getItems().get(0));
//        System.out.println(categoryCB.getItems().get(0));
        clickOn(addBt);
        assertTrue(textISBN.isVisible());
    }
}
