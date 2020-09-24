package com.myproject.basic;

import com.myproject.basic.oop.InfoItem;

import static com.myproject.basic.Main.printInfo;
import static com.myproject.basic.Main.print;

public class InnerClasses {

    public void test(){

        NearItem item1 = new NearItem();
        print("NearItem in InnerClasses");
        printInfo(item1);

        InClassItem item2 = new InClassItem();
        printInfo(item2);

        doSomething();
    }

    void doSomething(){

        class InMethodItem implements InfoItem {
            // Class is defined in the method.
        }
//        print("InMethodItem:");
        InMethodItem item3 = new InMethodItem();
        printInfo(item3);
    }

    class InClassItem implements InfoItem{
        // Class is defined in the class.
    }

    public static class StatInClass implements InfoItem {
        // static inner class
    }
}

class NearItem implements InfoItem {
    // Class is defined in the file near main class.
}
