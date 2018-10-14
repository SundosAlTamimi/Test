package com.tamimi.sundos.restpos.Models;

public class ClockInClockOut {
    private int pointOfSaleNumber;
    private String date;
    private int userNO;
    private String userName;
    private String transtype;
    private String dateCard;
    private String timeCard;
    private String remark;
    private int shiftNo;
    private String shiftName;

    public ClockInClockOut() {
    }

    public void setPointOfSaleNumber(int pointOfSaleNumber) {
        this.pointOfSaleNumber = pointOfSaleNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserNO(int userNO) {
        this.userNO = userNO;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public void setTimeCard(String timeCard) {
        this.timeCard = timeCard;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setShiftNo(int shiftNo) {
        this.shiftNo = shiftNo;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public int getPointOfSaleNumber() {
        return pointOfSaleNumber;
    }

    public String getDate() {
        return date;
    }

    public int getUserNO() {
        return userNO;
    }

    public String getUserName() {
        return userName;
    }

    public String getTranstype() {
        return transtype;
    }

    public String getDateCard() {
        return dateCard;
    }

    public String getTimeCard() {
        return timeCard;
    }

    public String getRemark() {
        return remark;
    }

    public int getShiftNo() {
        return shiftNo;
    }

    public String getShiftName() {
        return shiftName;
    }
}
