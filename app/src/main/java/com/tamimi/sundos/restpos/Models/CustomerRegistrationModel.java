package com.tamimi.sundos.restpos.Models;

public class CustomerRegistrationModel  {
    private String memberShipGroup;
    private int memberShipCardNO;
    private String customerName;
    private String customerCode;
    private String coender;
    private String streetNoName;
    private String city;
    private int phoneNo;
    private int mobileNo;
    private String nameShow;
    private String birthday;
    private String anniversary;
    private String occupation;
    private String email;
    private int totalPoint;
    private String remark;
    private int redeemedPoint;
    private int remainingPoint;
    private int shiftNO;
    private String shiftName;

    public CustomerRegistrationModel() {
    }

    public CustomerRegistrationModel(String memberShipGroup, int memberShipCardNO, String customerName, String customerCode, String coender, String streetNoName, String city, int phoneNo, int mobileNo, String nameShow, String birthday, String anniversary, String occupation, String email, int totalPoint, String remark, int redeemedPoint, int remainingPoint, int shiftNO, String shiftName) {
        this.memberShipGroup = memberShipGroup;
        this.memberShipCardNO = memberShipCardNO;
        this.customerName = customerName;
        this.customerCode = customerCode;
        this.coender = coender;
        this.streetNoName = streetNoName;
        this.city = city;
        this.phoneNo = phoneNo;
        this.mobileNo = mobileNo;
        this.nameShow = nameShow;
        this.birthday = birthday;
        this.anniversary = anniversary;
        this.occupation = occupation;
        this.email = email;
        this.totalPoint = totalPoint;
        this.remark = remark;
        this.redeemedPoint = redeemedPoint;
        this.remainingPoint = remainingPoint;
        this.shiftNO = shiftNO;
        this.shiftName = shiftName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setShiftNO(int shiftNO) {
        this.shiftNO = shiftNO;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public void setMemberShipGroup(String memberShipGroup) {
        this.memberShipGroup = memberShipGroup;
    }

    public void setMemberShipCardNO(int memberShipCardNO) {
        this.memberShipCardNO = memberShipCardNO;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setCoender(String coender) {
        this.coender = coender;
    }

    public void setStreetNoName(String streetNoName) {
        this.streetNoName = streetNoName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public void setRedeemedPoint(int redeemedPoint) {
        this.redeemedPoint = redeemedPoint;
    }

    public void setRemainingPoint(int remainingPoint) {
        this.remainingPoint = remainingPoint;
    }

    public String getMemberShipGroup() {
        return memberShipGroup;
    }

    public int getMemberShipCardNO() {
        return memberShipCardNO;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCoender() {
        return coender;
    }

    public String getStreetNoName() {
        return streetNoName;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getNameShow() {
        return nameShow;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public int getRedeemedPoint() {
        return redeemedPoint;
    }

    public int getRemainingPoint() {
        return remainingPoint;
    }

    public int getShiftNO() {
        return shiftNO;
    }

    public String getShiftName() {
        return shiftName;
    }

    public String getRemark() {
        return remark;
    }
}
