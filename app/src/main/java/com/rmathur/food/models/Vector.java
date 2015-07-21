package com.rmathur.food.models;

public class Vector {

    public double xComponent, yComponent;

    public Vector() {
        this.xComponent = 0;
        this.yComponent = 0;
    }

    public Vector (double x, double y) {
        this.xComponent = x;
        this.yComponent = y;
    }

    public double getDistance (){
        return Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
    }
}