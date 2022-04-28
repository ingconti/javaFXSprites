package com.example.drawSprites;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {

    private Coord coord = new Coord();
    ImageView imageView;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Hello!");
        Timer timer =  startTimer();

        Image img = new Image("strawberry.jpg");
        imageView = new ImageView(img);

        Image img2 = new Image("banana.jpg");
        ImageView imageView2 = new ImageView(img2);

        //Setting the position of the image
        imageView2.setX(10);
        imageView2.setY(300);

        //setting the fit height and width of the image view
        //imageView2.setFitHeight(455);
        //imageView2.setFitWidth(500);

        Group root = new Group();

        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);

        stage.setScene(new Scene(root));

        stage.setMaximized(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


    private void moveImage(){
        if (imageView == null) return;
        imageView.setX(coord.x);
        imageView.setY(coord.y);
    }

    private Timer startTimer(){
        Timer timer = new Timer("Timer");

        TimerTask task = new TimerTask() {
            public void run() {
                coord.moveX(12);
                System.out.println("HELLO " + coord.getX());

                Platform.runLater(() -> {
                    moveImage();
                });
            }
        };

        long delay = 0;
        long period = 1000L;
        timer.schedule(task, delay, period);
        return timer;
    } // startTimer
}