package com.codegymhueJava.model;

import java.util.ArrayList;

public class Table {
    private int id;
    private boolean status = false;
    public Table() {
    }

    public Table(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
