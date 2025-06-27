package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;



public class endGameController extends gameController implements basicFunctions{

    @FXML
    Label label;
    @Override
    public void startGame(ActionEvent event) throws IOException {

    }

    public void viewHighScore(ActionEvent event){
        label.setText(String.valueOf(i));
    }

    @Override
    public void exitGame(ActionEvent event) throws IOException {
        System.out.println("PLAY AGAIN SOON!!!");
        System.exit(0);
    }
}
