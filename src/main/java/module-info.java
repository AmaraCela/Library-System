module com.example.finalproject {
    opens models to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
    exports models;
}