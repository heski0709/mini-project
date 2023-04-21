package com.main.dto;

public class TypeDTO {

    private String name;
    private int price;

    protected TypeDTO() {}


    protected TypeDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + price;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeDTO other = (TypeDTO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price != other.price)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "name=" + name + ", price=" + price;
    }
}
