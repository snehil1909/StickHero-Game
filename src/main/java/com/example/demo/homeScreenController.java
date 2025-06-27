package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class homeScreenController extends gameController implements basicFunctions{

    @FXML
    private AnchorPane scenePane;
    Stage stage;

    public homeScreenController() throws IOException {
    }

    @FXML
    public Stage Display() throws IOException {

        Stage stage= new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartScreen.fxml")));

        stage.setTitle("StickHero");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        return stage;
    }
    @FXML
    public void startGame(@org.jetbrains.annotations.NotNull ActionEvent event) throws IOException {
        DisplayGameScreen(event);
    }

    @Override
    public void exitGame(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to exit the game");
        alert.setContentText("Do you want to save before exiting?");
        if(alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        }
    }


    public void viewHighScore(){

    }

    public void viewCherries(){

    }


}
