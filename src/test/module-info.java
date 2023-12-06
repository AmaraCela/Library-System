module Library.System {
    requires org.junit.jupiter.api;
    requires com.example.finalproject;
    requires org.junit.jupiter.params;
    requires mockito.all;
    requires javafx.base;

    opens modelsTest to org.junit.platform.commons;

    // Add the following line if you want to export the package for testing purposes
    exports modelsTest;

}
