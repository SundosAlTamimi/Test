package com.tamimi.sundos.restpos.Models;

public class Shift {
    private int shiftNo;
    private String shiftName;
    private String fromTime;
    private String toTime;

    public Shift() {
    }

    public Shift(int shiftNo, String shiftName, String fromTime, String toTime) {
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
        this.fromTime = fromTime;
        this.toTime = toTime;
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

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
