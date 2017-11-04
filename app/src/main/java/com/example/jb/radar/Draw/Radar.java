package com.example.jb.radar.Draw;

/**
 * Created by jb on 2017-05-26.
 */

public class Radar {

    private int height;
    private int width;

    public Radar(int height, int width) {
        this.height = height;
        this.width = width;

    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public double getCenterX() {
        return (width/2);
    }
    public double getCenterY() {
        return (height/2);
    }



}
