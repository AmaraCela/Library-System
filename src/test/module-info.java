module Library.System {
    requires org.junit.jupiter.api;
    requires com.example.finalproject;
    requires org.junit.jupiter.params;
    requires mockito.all;

    opens modelsTest to org.junit.platform.commons;
//    opens java.io to mockito.all;

    // Add the following line if you want to export the package for testing purposes
    exports modelsTest;
    exports mockFiles;
//    opens mockFiles to org.junit.platform.commons;
}
