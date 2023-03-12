module com.example.finalproject {
    opens models to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}