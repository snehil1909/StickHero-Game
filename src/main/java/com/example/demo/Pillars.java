package com.example.demo;

import java.util.Random;

public class Pillars{
    Random obj = new Random();
    private double distance=obj.nextDouble(230,400); //distance between pillars
    private int width= obj.nextInt(); //width of each pillar
    private double x_cord;

    public double getX_cord() {
        return x_cord;
    }

    public void setX_cord(int x_cord) {
        this.x_cord = x_cord;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public static double initDistance(){
        // sets distance  between pillars randomly
        Random obj = new Random();
        return obj.nextInt(230,400);
    }

    public static double initWidth(){
        // sets width of the pillar randomly
        Random obj = new Random();
        return obj.nextInt(50,150);
    }

}
