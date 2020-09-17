package com.myproject.basic;

import com.myproject.basic.oop.BiPoint;
import com.myproject.basic.oop.Point;

import static com.myproject.basic.Main.print;
import static com.myproject.basic.Main.hr;

public class Generics {
    public void test(){
        Point<Integer> intPoint = new Point(5, 10);
        print(intPoint);

        BiPoint<Integer, Double> bp1 = new BiPoint<>(10, 20.0005);
        BiPoint<Short, Float> bp2 = new BiPoint<>((short) 100, -30.15f);
        double dist = bp1.distance(bp2);
        print(bp1, "-", bp2,  "=", dist);
    }
}
