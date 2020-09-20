package com.myproject.basic;

import com.myproject.basic.oop.BiPoint;
import com.myproject.basic.oop.Point;

import static com.myproject.basic.Main.print;

public class Generics implements Demo {
    public void test(){
        // Unfolding
        Integer x = new Integer(1);
        Integer x2 = 2;
        int x3  = new Integer(3);

        // Custom generics
        Point<Integer> intPoint = new Point(5, 10);
        print(intPoint);

        BiPoint<Integer, Double> bp1 = new BiPoint<>(10, 20.0005);
        BiPoint<Short, Float> bp2 = new BiPoint<>((short) 100, -30.15f);
        double dist = bp1.distance(bp2);
        print(bp1, "-", bp2,  "=", dist);
    }
}
