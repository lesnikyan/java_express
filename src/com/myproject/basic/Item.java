package com.myproject.basic;

public class Item extends SuperItem {

    private String name;

    private static String defaultName = "noname";

    public Item(int id){
        this(id, defaultName);
    }

    public Item(int id, String name){
        super(id);
        this.setName(name);
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
