package com.tamimi.sundos.restpos.Models;

public class MemberShipGroup {

    private String memberShipGroup;
    private String userName;
    private int userNo;
    private String inDate;
    private int shiftNo;
    private String shiftName;
    private int Active;

    public MemberShipGroup() {
    }

    public MemberShipGroup(String memberShipGroup, String userName, int userNo, String inDate, int shiftNo, String shiftName, int active) {
        this.memberShipGroup = memberShipGroup;
        this.userName = userName;
        this.userNo = userNo;
        this.inDate = inDate;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
        this.Active = active;
    }

    public void setMemberShipGroup(String memberShipGroup) {
        this.memberShipGroup = memberShipGroup;
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
        Active = active;
    }

    public String getMemberShipGroup() {
        return memberShipGroup;
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
        return Active;
    }
}
