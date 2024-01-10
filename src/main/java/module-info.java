module com.example.finalproject {
    opens models to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires testfx.core;
    requires testfx.junit5;
    requires javafx.graphics;
    requires javafx.base;



    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
    exports models;
    exports Views;
    exports Controllers;
    exports Auxilaries;

//    opens Views to Library.System;

//    exports mock.mockFiles;
}
