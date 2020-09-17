// Package definition
package com.myproject.basic;


/*
Multi-line comment
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java-docs
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
	    // Application starting from here.

        // Import
        Importing importing = new Importing();
        importing.importing();
        importing.innerClasses();

        // Syntax
        BasicSyntax.test();

        // Methods
        new Methods().test();

        // OOP Inheritance
        hr(40);
        new BasicOOP().test();
        hr(40);
        new Inheritance().test();

        // Generic
        hr(40);
        new Generics().test();

        // Exceptions
        hr(40);
        new Exceptions().test();

        // Collections, Strings

        // Threads

        // Annotations

    }
    /**
     *
     * @param item
     */
    public static void printInfo(Object item){
        print(item.getClass().getName());
    }

    public static void print(int[] arg){
        System.out.println(Arrays.toString(arg));
    }

    public static void print(Printable arg){
        arg.print();
    }

    public static void print(Object... x){
        System.out.println(objToString(x));
    }

    public static String objToString(Object[] args){
        List<String> list = new ArrayList<>();
        Arrays.stream(args).forEach(s -> list.add(s.toString()));
        return String.join(" ", list);
    }

    public static String repeat(String src, int num){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < num; ++i){
            sb.append(src);
        }
        return sb.toString();
    }

    public static void hr(int... size){
        int s = size.length > 0 ? size[0]: 20;
        print(repeat("-", s));
    }
}
