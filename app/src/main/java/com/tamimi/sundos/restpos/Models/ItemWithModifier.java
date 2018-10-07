package com.tamimi.sundos.restpos.Models;

public class ItemWithModifier {
    private int itemCode;
    private int modifierNo;
    private String modifierText;

    public ItemWithModifier(){

    }

    public ItemWithModifier(int itemCode, int modifierNo, String modifierText) {
        this.itemCode = itemCode;
        this.modifierNo = modifierNo;
        this.modifierText = modifierText;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getModifierNo() {
        return modifierNo;
    }

    public void setModifierNo(int modifierNo) {
        this.modifierNo = modifierNo;
    }

    public String getModifierText() {
        return modifierText;
    }

    public void setModifierText(String modifierText) {
        this.modifierText = modifierText;
    }
}
