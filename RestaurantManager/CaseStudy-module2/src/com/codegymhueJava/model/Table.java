package com.codegymhueJava.model;

public class Table {
    private int id;
    private String name;

    public int count;

    public Table() {
    }

    public int autoID() {
        return count++;
    }

    public Table(String name) {
        this.id = autoID();
        this.name = name;
    }

    public Table(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name;
    }
}
