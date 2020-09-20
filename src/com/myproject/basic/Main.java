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

    public static void main(String[] args) {

        // Import
        test(new Importing());

        // Syntax
        test(new BasicSyntax());

        // Methods
        test(new Methods());

        // Basic OOP
        test(new BasicOOP());

        // OOP Inheritance
        test(new Inheritance());

        // Generic
        test(new Generics());

        // Exceptions
        test(new Exceptions());

        // Collections, Strings
        test(new CollectionsDemo());

        // Functions
        test(new Functions());

        // Input-Output Streams
        test(new IOStreamDemo());

        // Threads
        test(new ThreadDemo());

        // Annotations
        test(new AnnotationsDemo());
    }

    public static void test(Demo demo){
        hr(40);
        print(" - - Demo of ", demo.getClass().getSimpleName(), " - -");
        demo.test();
    }

    /**
     *
     * @param item
     */
    public static void printInfo(Object item){
        print(item.getClass().getName());
    }

    public static void print(Printable arg){
        arg.print();
    }

    public static void print(int[] arg){
        System.out.println(Arrays.toString(arg));
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
