package com.example.drawSprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite implements Movable {
    double x, y;
    String fname;
    ImageView imageView;

    public Sprite(double x, double y, String fname) {
        this.x = x;
        this.y = y;
        this.fname = fname;

        Image img = new Image(fname);
        this.imageView = new ImageView(img);
    }

    @Override
    public void MoveUp(){
        this.y-=10;
        updatePos();
    }

    @Override
    public void MoveDown(){
        this.y+=10;
        updatePos();
    }

    @Override
    public void MoveLeft(){
        this.x-=10;
        updatePos();
    }

    @Override
    public void MoveRight(){
        this.x+=10;
        updatePos();
    }

    void updatePos(){
        this.imageView.setX(this.x);
        this.imageView.setY(this.y);
    }

    public ImageView getImageView() {
        return this.imageView;
    }
}
