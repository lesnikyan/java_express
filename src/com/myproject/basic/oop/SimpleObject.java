package com.myproject.basic.oop;


/**
 * POJO: Plain Old Java Object
 */
public class SimpleObject {

    // class fields

    private String name;
//    public int x;
//    protected int y;

    // Constructor

    public SimpleObject(String name){
        this.name = name;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class MostSimpleObject {
    // no any members
}
