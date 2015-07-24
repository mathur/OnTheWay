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

    public double getLength (){
        return Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
    }

    public double dotProduct(double x, double y) {
        return (this.xComponent * x) + (this.yComponent * y);
    }

    public void scaleVector(double scalar) {
        this.xComponent = this.xComponent * scalar;
        this.yComponent = this.yComponent * scalar;
    }

    public void makeUnitVector() {
        double length = this.getLength();
        this.xComponent = this.xComponent / length;
        this.yComponent = this.yComponent / length;
    }

}