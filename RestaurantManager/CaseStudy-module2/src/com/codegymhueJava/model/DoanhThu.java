package com.codegymhueJava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DoanhThu {
    private int totalPrice;
    private String time;


    public DoanhThu() {
    }

    public DoanhThu(int totalPrice, String time) {
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

    @Override
    public String toString() {
        return totalPrice + "," + time;
    }
}
