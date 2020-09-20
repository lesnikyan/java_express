package com.myproject.basic;

public class SuperExpressDemo {

    private final String name;

    private int id = 1;

    private Color color = new Color(0xff, 0xff, 0);

    public SuperExpressDemo(String name){
        this.name = name;
    }

    public Color getColor(){
        return color;
    }

    public void setId(int id){
        this.id = id;
    }

}


class Color {

    int red = 0;
    int green = 0;
    int blue = 0;

    public Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}