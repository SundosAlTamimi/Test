package com.tamimi.sundos.restpos.Models;

public class CreditCard {

    private int serial;
    private String cardName;
    private String AccCode;

    public CreditCard(){

    }

    public CreditCard(int serial, String cardName, String accCode) {
        this.serial = serial;
        this.cardName = cardName;
        AccCode = accCode;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getAccCode() {
        return AccCode;
    }

    public void setAccCode(String accCode) {
        AccCode = accCode;
    }
}
