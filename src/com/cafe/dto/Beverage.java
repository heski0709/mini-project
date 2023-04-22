package com.cafe.dto;

public class Beverage extends BeverageOptionDTO {

    public Beverage(String name, int price, String size) {
        super(name, price, size, 0, false, false, false, false);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
