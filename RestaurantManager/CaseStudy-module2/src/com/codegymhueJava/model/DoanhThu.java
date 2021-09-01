package com.codegymhueJava.model;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DoanhThu {
    private String name;
    private int quantity;
    private int price;
    private int totalPrice;
    private String time;


    public DoanhThu() {
    }

    public DoanhThu(int totalPrice, String time) {
        this.totalPrice = totalPrice;
        this.time = time;
    }

    public DoanhThu(String name, int quantity, int price, int totalPrice, String time) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.time = time;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString() {
        return totalPrice + "," + time;
    }

    public String toStringFull() {
        return name + "," + quantity + "," + price + "," + totalPrice + "," + time;
    }
}
