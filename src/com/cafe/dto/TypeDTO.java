package com.cafe.dto;

public class TypeDTO {
    private String name;
    private int price;

    protected TypeDTO() {}

    protected TypeDTO(String name, int price) {
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
