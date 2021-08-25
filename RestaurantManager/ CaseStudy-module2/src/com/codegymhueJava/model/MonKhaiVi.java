package com.codegymhueJava.model;

public class MonKhaiVi {
    private String name;
    private int price;

    public MonKhaiVi() {
    }

    public MonKhaiVi(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "," + price;
    }
}
