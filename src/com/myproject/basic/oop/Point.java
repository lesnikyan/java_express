package com.myproject.basic.oop;

public class Point<T extends Number> {

    T x;
    T y;

    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }

    public Point clone(){
        return new Point<T>(x, y);
    }

    public Point<Double> doubleValue(){
        return new Point(x.doubleValue(), y.doubleValue());
    }

    public Double distance(Point<T> point){
        double dx = x.doubleValue() - point.x.doubleValue();
        double dy = y.doubleValue() - point.y.doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString(){
        return String.format("Point<%s>(%s, %s)", x.getClass().getSimpleName(), x, y);
    }
}
