package com.myproject.basic;

public class SuperItem {

    private int id;

    private static int lastId = 0;

    public SuperItem(){
        this(++lastId);
    }

    public SuperItem(int id){
        this.id = id;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
