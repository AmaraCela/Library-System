package com.example.finalproject;

import Controllers.LogInController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import Views.*;
import models.*;
import Controllers.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //new Administrator("Amara", "Cela", "acela@gmail.com", "29/12/2001", "acela21", "12345678", 3000, "067 71 71 711");
        RegisterStaffController.readFromFile();
        CategoryController.updateCategories();
        WelcomeView welcomeView = new WelcomeView();

        Scene scene = new Scene(welcomeView,1000,600);
        welcomeView.getEnterBt().setOnAction(e->
        {
            LogInView logInView = new LogInView(stage);
            new LogInController(logInView);

        });
        stage.setScene(scene);
        stage.setTitle("Library system");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}