package com.tamimi.sundos.restpos.Models;

public class Recipes {

    private int barcode;
    private String item;
    private String unit;
    private int qty;
    private double cost;

    public Recipes(int barcode, String item, String unit, int qty, double cost) {
        this.barcode = barcode;
        this.item = item;
        this.unit = unit;
        this.qty = qty;
        this.cost = cost;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
