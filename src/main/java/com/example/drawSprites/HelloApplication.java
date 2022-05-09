package com.example.drawSprites;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    String[] fileNames = {"strawberry.png", "banana.png", "strawberry.png"};

    List<Sprite> sprites = new ArrayList<>();
    int counter = 0;
    Group root;
    Timer timer;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Hello!");

        Timer timer =  startTimer();

        root = new Group();
        stage.setScene(new Scene(root));

        stage.setWidth(600);
        stage.setHeight(600);

        stage.show();
        stage.setMaximized(true);
    }


    public static void main(String[] args) {
        launch();
    }

    private void moveImages(){
        for (Sprite s: this.sprites) {
            s.MoveDown();
        }
    }

    private void updateImages(){
        for (Sprite s: this.sprites) {
            s.updatePos();
        }
    }
    void randomizeAndAdd(){
        if (counter % 10 == 0){
            int index = counter % fileNames.length;
            double x = Math.random() * 500;
            Sprite sprite = new Sprite(x,50, fileNames[index]);
            this.sprites.add(sprite);

            ImageView imgV = sprite.getImageView();
            root.getChildren().add(imgV);
            updateImages();
        }
        moveImages();
        counter++;

    }


    private Timer startTimer(){
        timer = new Timer("Timer");

        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {
                    randomizeAndAdd();
                });
            }
        };

        long delay = 0;
        long period = 100L;
        timer.schedule(task, delay, period);
        return timer;
    } // startTimer
}