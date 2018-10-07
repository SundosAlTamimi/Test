package com.tamimi.sundos.restpos.Models;

public class CategoryWithModifier {
    private String modifierName;
    private String categoryName;

    public CategoryWithModifier(){

    }
    public CategoryWithModifier(String modifierName, String categoryName) {
        this.modifierName = modifierName;
        this.categoryName = categoryName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
