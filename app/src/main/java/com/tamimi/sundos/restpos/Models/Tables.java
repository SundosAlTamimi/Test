package com.tamimi.sundos.restpos.Models;

public class Tables {

    private int height;
    private int width;
    private int imageResource;
    private float marginLeft;
    private float marginTop;
    private int tableNumber;

    public Tables(){

    }

    public Tables(int height, int width, int imageResource, float marginLeft, float marginTop , int tableNumber) {
        this.height = height;
        this.width = width;
        this.imageResource = imageResource;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.tableNumber = tableNumber;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public float getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(float marginLeft) {
        this.marginLeft = marginLeft;
    }

    public float getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(float marginTop) {
        this.marginTop = marginTop;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
