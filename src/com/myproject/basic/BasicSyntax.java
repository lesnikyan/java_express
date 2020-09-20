package com.myproject.basic;

import java.util.Arrays;
import java.util.Random;

import static com.myproject.basic.Main.*;

/**
 * Class docs
 */
public class BasicSyntax implements Demo {

    /**
     * Method docs
     */
    public void test(){

        boolean isAllGood = true;
        boolean isAllBad = false;

        int age = 25;
        long kilometersToAlphaCentauri = 4367L * (long) 9.46e9;
        print(kilometersToAlphaCentauri);

        char c = 'C';
        byte b = 0x0f;
        short bin = 0b010;
        print("bin: " + bin);

        // bin
        int binVal = 0b100100;
        // hex
        int hexVal = 0xf0f0;

        float f1 = 1.0f;
        float f2 = 5F;
        double d1 = 1.000000000001;
        double d2 = .5; // 0.5
        double d3 = (double) 1.2f;


        // Arrays

        int[] nums = {1, 2, 3};
        int[] years = new int[5];
        for(int i = 0; i < 5; ++i){
            years[i] = 2005 + i;
        }
        print(years);

        String[][] nameMatrix = {
                {"Vasya", "Vova", "Goga"},
                {"Olya", "Yula", "Lyolya"}
        };
        for(String[] names : nameMatrix){
            for(String name : names){
                print(name);
            }
        }

        // Hex numbers in `while`
        int count = 0xf; // 15
        String[] strNums = new String[count + 1];
        while(count >= 0){
            strNums[count] = String.format(" [%x] ", count);
            count --;
        }
        print(String.join(" ", strNums));

        // Random numbers in `for`
        Random rnd = new Random();
        int[] rnums = new int[10];
        for(int i=0; i < 10; ++i){
            rnums[i] = 100 + rnd.nextInt(99);
        }

        for(int n : rnums){
            if((n & 1) != 0){
                print("-odd: " + n);
            } else {
                print("=even:" + n);
            }
        }

        // Switch
        Item[] items = {
                new Item(1, "aaa"),
                new Item(2, "bbb"),
                new Item(3, "ccc"),
                new Item(5, "Spartaaa")
        };
        for(Item item : items){
            switch(item.getId()){
                case 1: print("First item: " + item.getName());
                    break;
                case 2: print("Second item: " + item.getName());
                    break;
                case 3: print("Third item: " + item.getName());
                    break;
                default: print("Freedooom! We are " + item.getName() + "!");
            }
        }

    }
}
