package com.myproject.basic;

import static com.myproject.basic.Main.printInfo;
import static com.myproject.basic.Main.print;

// https://www.javatpoint.com/static-nested-class

public class InnerStatic {
    public void test(){
        print(StaticSubItem.statInfo());

        StaticSubItem subItem = new StaticSubItem();
        printInfo(subItem);
    }

    public static class StaticSubItem {

        public static String statInfo(){
            return StaticSubItem.class.getName();
        }

    }
}
