package com.tamimi.sundos.restpos.Models;

public class JobGroup  {

    private String jobGroup ;
    private String userName ;
    private int userNo ;
    private String inDate;
    private int shiftNo;
    private String shiftName;
    private int  active;

    public JobGroup() {
    }

    public JobGroup(String jobGroup, String userName, int userNo, String inDate, int shiftNo, String shiftName,int  active) {
        this.jobGroup = jobGroup;
        this.userName = userName;
        this.userNo = userNo;
        this.inDate = inDate;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
        this.active = active;
    }



    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public void setShiftNo(int shiftNo) {
        this.shiftNo = shiftNo;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getInDate() {
        return inDate;
    }

    public int getShiftNo() {
        return shiftNo;
    }

    public String getShiftName() {
        return shiftName;
    }
    public int getActive() {
        return active;
    }
}
