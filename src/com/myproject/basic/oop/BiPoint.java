package com.myproject.basic.oop;

public class BiPoint<T extends Number, K extends Number> {
    public T x;
    public K y;

    public BiPoint(){
        x = null;
        y = null;
    }

    public BiPoint(T x, K y){
        this.x = x;
        this.y = y;
    }
    public Point<Double> doubleValue(){
        return new Point(x.doubleValue(), y.doubleValue());
    }

    public Double distance(BiPoint<?, ?> point){
        double dx = x.doubleValue() - point.x.doubleValue();
        double dy = y.doubleValue() - point.y.doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString(){
        return String.format("BiPoint<%s>(%s, %s)", x.getClass().getSimpleName(), x, y);
    }
}
