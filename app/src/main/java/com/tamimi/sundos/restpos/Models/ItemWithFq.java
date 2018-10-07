package com.tamimi.sundos.restpos.Models;

public class ItemWithFq {
    private int itemCode;
    private int questionNo;
    private String questionText;

    public ItemWithFq(){

    }

    public ItemWithFq(int itemCode, int questionNo, String questionText) {
        this.itemCode = itemCode;
        this.questionNo = questionNo;
        this.questionText = questionText;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
