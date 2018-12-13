package com.tamimi.sundos.restpos.Models;

public class BlindCloseDetails {
    private int transNo;
    private String date;
    private String time;
    private int POSNo;
    private int shiftNo;
    private String shiftName;
    private int userNo;
    private String userName;
    private String catName;
    private int catQty;
    private double catValue;
    private double catTotal;
    private String type;
    private String updateDate;
    private String updateTime;
    private int updateUserNo;
    private String updateUserName;

    public BlindCloseDetails(){
    }

    public BlindCloseDetails(int transNo, String date, String time, int POSNo, int shiftNo, String shiftName, int userNo,
                             String userName, String catName, int catQty, double catValue, double catTotal, String type,
                             String updateDate, String updateTime, int updateUserNo, String updateUserName) {
        this.transNo = transNo;
        this.date = date;
        this.time = time;
        this.POSNo = POSNo;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
        this.userNo = userNo;
        this.userName = userName;
        this.catName = catName;
        this.catQty = catQty;
        this.catValue = catValue;
        this.catTotal = catTotal;
        this.type = type;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserNo = updateUserNo;
        this.updateUserName = updateUserName;
    }

    public int getTransNo() {
        return transNo;
    }

    public void setTransNo(int transNo) {
        this.transNo = transNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPOSNo() {
        return POSNo;
    }

    public void setPOSNo(int POSNo) {
        this.POSNo = POSNo;
    }

    public int getShiftNo() {
        return shiftNo;
    }

    public void setShiftNo(int shiftNo) {
        this.shiftNo = shiftNo;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatQty() {
        return catQty;
    }

    public void setCatQty(int catQty) {
        this.catQty = catQty;
    }

    public double getCatValue() {
        return catValue;
    }

    public void setCatValue(double catValue) {
        this.catValue = catValue;
    }

    public double getCatTotal() {
        return catTotal;
    }

    public void setCatTotal(double catTotal) {
        this.catTotal = catTotal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateUserNo() {
        return updateUserNo;
    }

    public void setUpdateUserNo(int updateUserNo) {
        this.updateUserNo = updateUserNo;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
}
