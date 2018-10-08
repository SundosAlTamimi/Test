package com.tamimi.sundos.restpos.Models;

public class CustomerPayment  {

    private int pointOfSaleNumber;
    private int userNO;
    private String userName;
    private int customerNo;
    private String customerName;
    private double customerBalance;
    private int transNo;
    private String transDate;
    private String payMentType;
    private double value;
    private int shiftNo;
    private String shiftName;

    public CustomerPayment() {

    }

    public void setShiftNo(int shiftNo) {
        this.shiftNo = shiftNo;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public void setPointOfSaleNumber(int pointOfSaleNumber) {
        this.pointOfSaleNumber = pointOfSaleNumber;
    }

    public void setUserNO(int userNO) {
        this.userNO = userNO;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public void setTransNo(int transNo) {
        this.transNo = transNo;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public void setPayMentType(String payMentType) {
        this.payMentType = payMentType;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getPointOfSaleNumber() {
        return pointOfSaleNumber;
    }

    public int getUserNO() {
        return userNO;
    }

    public String getUserName() {
        return userName;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public int getTransNo() {
        return transNo;
    }

    public String getTransDate() {
        return transDate;
    }

    public String getPayMentType() {
        return payMentType;
    }

    public int getShiftNo() {
        return shiftNo;
    }

    public String getShiftName() {
        return shiftName;
    }

    public double getValue() {
        return value;
    }
}
