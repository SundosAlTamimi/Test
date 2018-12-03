package com.tamimi.sundos.restpos.Models;

public class BlindShift {
    private String date;
    private String time;
    private int posNo;
    private int shiftNo;
    private String shiftName;
    private int userNo;
    private String userName;
    private int status;

    public BlindShift(){
    }

    public BlindShift(String date, String time, int posNo, int shiftNo, String shiftName, int userNo, String userName, int status) {
        this.date = date;
        this.time = time;
        this.posNo = posNo;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
        this.userNo = userNo;
        this.userName = userName;
        this.status = status;
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

    public int getPosNo() {
        return posNo;
    }

    public void setPosNo(int posNo) {
        this.posNo = posNo;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

