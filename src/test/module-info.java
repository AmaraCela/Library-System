module Library.System {
    requires org.junit.jupiter.api;
    requires com.example.finalproject;
    requires org.junit.jupiter.params;
    requires mockito.all;
    requires javafx.base;
    requires javafx.graphics;
    requires testfx.core;
    requires testfx.junit5;
    requires javafx.controls;

    opens modelsTest to org.junit.platform.commons;
    opens controllerTest to org.junit.platform.commons;
    opens mockFiles to com.example.finalproject;
    opens IntegrationTest to org.junit.platform.commons;
//    opens java.io to mockito.all;

    // Add the following line if you want to export the package for testing purposes
    exports modelsTest;
    exports mockFiles;
//    exports models;

//    opens mockFiles to org.junit.platform.commons;
}
