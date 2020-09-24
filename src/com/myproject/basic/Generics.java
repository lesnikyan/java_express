package com.myproject.basic;

import com.myproject.basic.oop.BiPoint;
import com.myproject.basic.oop.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


class OneGen<T> {
    T arg;
    public OneGen(T arg){
        this.arg = arg;
    }
}

class TwoGen<T, K> {
    T x;
    K y;
    public TwoGen(T x, K y){
        this.x = x;
        this.y = y;
    }
}

class ExtGen<T, K> extends OneGen<T> {
    K arg2;
    public ExtGen(T arg1, K arg2){
        super(arg1);
        arg2 = arg2;
    }
}

class GetGen<T> {
    T arg;
    public GetGen(T arg){
        this.arg = arg;
    }

    public T getArg(){
        return arg;
    }
}

class ContGen<T, K>{
    List<T> list = new ArrayList<>();
    Map<T, K> map = new HashMap<>();

    public void add(T key, K val){
        map.put(key, val);
        list.add(key);
    }
}

class ExtTypeGen<T extends Number>{
    public T val;
}

class GetExtGen <T, K> extends GetGen<K> {
    T arg2;
    public GetExtGen(K a1, T a2){
        super(a1);
        arg2 = a2;
    }
}

class ExtGenOfGen<T> extends OneGen<List<T>>{
    T oneVal;
    public ExtGenOfGen(T arg){
        super(new ArrayList<T>()); // set super.arg
        oneVal = arg;
        this.arg.add(arg);
    }
}
