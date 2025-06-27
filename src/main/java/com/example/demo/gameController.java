package com.example.demo;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    private static final double MAX_Y_CORD = 249.99;
    @FXML
    Button gameButton;

    @FXML
    Rectangle stick;

    @FXML
    ImageView Hero;

    @FXML
    Label label;
    FXMLLoader gameloader = new FXMLLoader(getClass().getResource("Scene.fxml"));
    FXMLLoader endScreenloader = new FXMLLoader(getClass().getResource("EndScreen.fxml"));
    Scene scene;
    static Pane pane;

    public static Rectangle Pillar1=generatePillar1();

    public static Rectangle Pillar2= generatePillar2();

    Rectangle newPillar = generatePillar1();
    Boolean isFall= false;
    static Stage stage1;
    Parent root1;
    int i=0;

    public void DisplayGameScreen(ActionEvent event) throws IOException {
        Parent root = gameloader.load();
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
        pane = (Pane) scene.getRoot();
        pane.getChildren().add(Pillar1);
        pane.getChildren().add(Pillar2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void heroFall(){

    }

    public void flipHero(){
        // flips hero on the bridge to collect cherries
    }

    public void movePillars(){
        //to move pillars after each step.

    }

    public void playBackgroundMusic(){

    }


    public void setRedDot(){

    }
    public static Rectangle generatePillar1(){
        Rectangle Pillar;
        Pillar = new Rectangle();
        Pillar.setHeight(195);
        Pillar.setWidth(Pillars.initWidth());
        Pillar.setY(268);
        Pillar.setX(Pillars.initDistance());
        return Pillar;
    }

    private static Rectangle generatePillar2(){
        Rectangle Pillar;
        Pillar = new Rectangle();
        Pillar.setHeight(195);
        Pillar.setWidth(100);
        Pillar.setY(268);
        Pillar.setX(75);
        return Pillar;
    }

    public void moveHero(ImageView hero, Rectangle rectangle) throws RuntimeException{
        // moves hero in the forward direction automatically
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), hero);
        translateTransition.setByX(rectangle.getHeight()+20);
        translateTransition.setByY(0);
        translateTransition.setOnFinished(event -> {
            if(isFall){
                TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1),Hero);
                fallTransition.setByY(2500);
                fallTransition.play();
                fallTransition.setOnFinished(event1 -> {
                    try {
                        root1 = endScreenloader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    scene = new Scene(root1);
                    stage1.setScene(scene);
                    stage1.show();
                });
            }
            else {
                i+=1;
                label.setText(String.valueOf(i));
            }
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.25),Pillar1);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.25),hero);
            TranslateTransition translateTransition5 = new TranslateTransition(Duration.seconds(0.25),newPillar);
            translateTransition2.setToX(0);
            translateTransition1.setByX(-1000);
            translateTransition5.setByX(-1000);
            translateTransition5.play();
            translateTransition5.setOnFinished(event1 -> {
                newPillar = generatePillar1();
                pane.getChildren().add(newPillar);
                javafx.scene.transform.Rotate rotate = new javafx.scene.transform.Rotate();
                rotate.setAngle(0);
                rotate.setPivotX(stick.getX() + stick.getWidth() / 2);
                rotate.setPivotY(stick.getY() + stick.getHeight());
                stick.getTransforms().add(rotate);
                Timeline timeline = new Timeline();
                KeyValue keyValue = new KeyValue(rotate.angleProperty(),-90);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.0005), keyValue);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
                timeline.setOnFinished(event2 -> {
                    stick.setHeight(1);
                    stick.setY(-stick.getHeight());
                });
            });
            translateTransition1.play();
            translateTransition2.play();
//            translateTransition5.play();

        });
        translateTransition.play();
    }


    public void increaseHeight(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(gameButton.isPressed()){
                    if(checkStickLengthLimit(stick)) {
                        stick.setHeight(stick.getHeight() + 2);
                        stick.setY(stick.getY() - 2);
                    }
                }
            }
        };
        animationTimer.start();
    }

    public boolean checkStickLengthLimit(Rectangle rectangle){
        return rectangle.getHeight() <= MAX_Y_CORD;
    }

    public void rotateStick(){

        javafx.scene.transform.Rotate rotate = new javafx.scene.transform.Rotate();
        rotate.setAngle(0);
        rotate.setPivotX(stick.getX() + stick.getWidth() / 2);
        rotate.setPivotY(stick.getY() + stick.getHeight());
        stick.getTransforms().add(rotate);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(rotate.angleProperty(),90);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        EventHandler<ActionEvent> onFinishedHandler= event -> {
            moveHero(Hero,stick);
            if(!(stick.getHeight()>=Pillar1.getX()-Pillar2.getX()-(Pillar2.getWidth()/2)-(Pillar1.getWidth()/2))){
                System.out.println("fall");
                isFall=true;
            }
        };
        timeline.setOnFinished(onFinishedHandler);
        timeline.play();
    }
}
