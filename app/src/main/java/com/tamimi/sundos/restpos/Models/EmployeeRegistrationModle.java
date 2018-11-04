package com.tamimi.sundos.restpos.Models;

public class EmployeeRegistrationModle {
    private String jobGroup;
    private int employeeNO;
    private String employeeName;
    private int mobileNo;
    private String securityLevel;
    private int userPassword;
    private int active;
    private String hireDate;
    private String terminationDate;
    private String payBasic;
    private String payRate;
    private String HolidayPay;
    private int shiftNo;
    private String shiftName;

    public EmployeeRegistrationModle() {
    }

    public EmployeeRegistrationModle(String jobGroup, int employeeNO, String employeeName, int mobileNo, String securityLevel, int userPassword, int active, String hireDate, String terminationDate, String payBasic, String payRate, String holidayPay, int shiftNo, String shiftName) {
        this.jobGroup = jobGroup;
        this.employeeNO = employeeNO;
        this.employeeName = employeeName;
        this.mobileNo = mobileNo;
        this.securityLevel = securityLevel;
        this.userPassword = userPassword;
        this.active = active;
        this.hireDate = hireDate;
        this.terminationDate = terminationDate;
        this.payBasic = payBasic;
        this.payRate = payRate;
        HolidayPay = holidayPay;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public void setEmployeeNO(int employeeNO) {
        this.employeeNO = employeeNO;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setPayBasic(String payBasic) {
        this.payBasic = payBasic;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public void setHolidayPay(String holidayPay) {
        HolidayPay = holidayPay;
    }

    public void setShiftNo(int shiftNo) {
        this.shiftNo = shiftNo;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public int getEmployeeNO() {
        return employeeNO;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public int getActive() {
        return active;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public String getPayBasic() {
        return payBasic;
    }

    public String getPayRate() {
        return payRate;
    }

    public String getHolidayPay() {
        return HolidayPay;
    }

    public int getShiftNo() {
        return shiftNo;
    }

    public String getShiftName() {
        return shiftName;
    }

    public String getJobGroup() {
        return jobGroup;
    }
}
