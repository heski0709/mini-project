package com.cafe.dto;

public class Beverage extends OptionDTO {

    public Beverage(String name, int price, String size, 
            int addShot, boolean isSyrup, boolean isIce, 
            boolean isCold, boolean isSizeUp) {
        super(name, price, size, addShot, isSyrup, isIce, isCold, isSizeUp);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
