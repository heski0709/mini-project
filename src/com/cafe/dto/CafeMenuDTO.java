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
        return "name=" + name + ", price=" + price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
