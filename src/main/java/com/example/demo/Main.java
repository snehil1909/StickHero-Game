package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        homeScreenController obj = new homeScreenController();
        stage = obj.Display();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}