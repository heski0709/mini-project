package com.cafe.dto;

public class CafeMenuDTO {
    private String name;
    private int price;

    protected CafeMenuDTO() {}

    protected CafeMenuDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "메뉴명 = " + name + "\n가격 = " + price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
}
