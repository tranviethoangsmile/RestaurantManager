package com.codegymhueJava.model;

public class FoodsObj {
    private String id;
    private String name;
    private int quantity;
    private int price;

    public FoodsObj() {
    }

    public FoodsObj(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public FoodsObj(String id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
       return String.format("%20s%10d%10d",name,quantity,price);
    }
    public String toStringID() {
        return String.format("%5d%20s%10d%10d",id,name,quantity,price);
    }


}
