package com.tamimi.sundos.restpos.Models;

public class OrderTransactions {

    private int orderType;
    private int orderKind;
    private String voucherDate;
    private int posNo;
    private int storeNo;
    private String voucherNo;
    private int voucherSerial;
    private String itemBarcode;
    private String itemName;
    private String secondaryName;
    private String kitchenAlias;
    private String itemCategory;
    private String itemFamily;
    private int qty;
    private double price;
    private double total;
    private double discount;
    private double lDiscount;
    private double totalDiscount;
    private double taxValue;
    private double taxPerc;
    private int taxKind;
    private double service;
    private double serviceTax;
    private int tableNo;
    private int sectionNo;
    private int shiftNo;
    private String shiftName;

    public OrderTransactions(){

    }

    public OrderTransactions(int orderType, int orderKind, String voucherDate, int posNo, int storeNo, String voucherNo,
                             int voucherSerial, String itemBarcode, String itemName, String secondaryName, String kitchenAlias,
                             String itemCategory, String itemFamily, int qty, double price, double total, double discount,
                             double lDiscount, double totalDiscount, double taxValue, double taxPerc, int taxKind, double service,
                             double serviceTax, int tableNo, int sectionNo , int shiftNo , String shiftName) {
        this.orderType = orderType;
        this.orderKind = orderKind;
        this.voucherDate = voucherDate;
        this.posNo = posNo;
        this.storeNo = storeNo;
        this.voucherNo = voucherNo;
        this.voucherSerial = voucherSerial;
        this.itemBarcode = itemBarcode;
        this.itemName = itemName;
        this.secondaryName = secondaryName;
        this.kitchenAlias = kitchenAlias;
        this.itemCategory = itemCategory;
        this.itemFamily = itemFamily;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.discount = discount;
        this.lDiscount = lDiscount;
        this.totalDiscount = totalDiscount;
        this.taxValue = taxValue;
        this.taxPerc = taxPerc;
        this.taxKind = taxKind;
        this.service = service;
        this.serviceTax = serviceTax;
        this.tableNo = tableNo;
        this.sectionNo = sectionNo;
        this.shiftNo = shiftNo;
        this.shiftName = shiftName;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderKind() {
        return orderKind;
    }

    public void setOrderKind(int orderKind) {
        this.orderKind = orderKind;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public int getPosNo() {
        return posNo;
    }

    public void setPosNo(int posNo) {
        this.posNo = posNo;
    }

    public int getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(int storeNo) {
        this.storeNo = storeNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public int getVoucherSerial() {
        return voucherSerial;
    }

    public void setVoucherSerial(int voucherSerial) {
        this.voucherSerial = voucherSerial;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String seconaryName) {
        this.secondaryName = seconaryName;
    }

    public String getKitchenAlias() {
        return kitchenAlias;
    }

    public void setKitchenAlias(String kitchenAlias) {
        this.kitchenAlias = kitchenAlias;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemFamily() {
        return itemFamily;
    }

    public void setItemFamily(String itemFamily) {
        this.itemFamily = itemFamily;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getlDiscount() {
        return lDiscount;
    }

    public void setlDiscount(double lDiscount) {
        this.lDiscount = lDiscount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getTaxPerc() {
        return taxPerc;
    }

    public void setTaxPerc(double taxPerc) {
        this.taxPerc = taxPerc;
    }

    public int getTaxKind() {
        return taxKind;
    }

    public void setTaxKind(int taxKind) {
        this.taxKind = taxKind;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
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
}
