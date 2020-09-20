package com.myproject.basic;

// https://www.tutorialspoint.com/java/java_exceptions.htm


import java.util.logging.Level;
import java.util.logging.Logger;

import static com.myproject.basic.Main.print;
import static com.myproject.basic.Main.repeat;

public class Exceptions implements Demo {

    Logger logger = Logger.getLogger(Exceptions.class.getName());

    private void log(String msg){
        logger.log(Level.WARNING, msg);
    }

    public void test(){
        // System exceptions
        try {
            numDiv(1, 2, 0, 4);
        } catch (ArithmeticException ex) {
            log("Exception error: " + ex.getMessage());
        }

        // Custom exceptions
        testRepeated("red.", 3);
        testRepeated("blue.", 1);
        testRepeated("green.", -5);
        testRepeated("black.", 44);
        testRepeated("black.", 1000000);

    }

    public void numDiv(int... nums) throws ArithmeticException {
        int res = 0;
        for(int x : nums){
            res += 100 / x;
        }
        print(res);
    }

    private void testRepeated(String word, int count){
        try {
            print("Repeat: ",  getRepeated(word, count));
        } catch(TooSmallCount exc) {
            log("Repeated Exception: " + exc.getMessage());
        } catch(TooBigCount | ExtremelyBigCount exc) {
            log("Repeated Exception: " + exc.getMessage());
        } catch(IllegalArgumentException exc){
            log("Repeated Exception: " + exc.getMessage());
        }
    }

    public String getRepeated(String word, int count) throws IllegalArgumentException {
        if(count < 0){
            throw new IllegalArgumentException("Count is less then zero.");
        }
        if(count < 2){
            throw new TooSmallCount();
        }
        if(count > 1000){
            throw new ExtremelyBigCount();
        }
        if(count > 20){
            throw new TooBigCount();
        }
        return repeat(word, count);
    }

    class TooSmallCount extends IllegalArgumentException {
        public TooSmallCount(){
            super("Too small count.");
        }
    }

    class TooBigCount extends IllegalArgumentException {
        public TooBigCount(){
            super("Too big count.");
        }
    }

    class ExtremelyBigCount extends IllegalArgumentException {
        public ExtremelyBigCount(){
            super("Extremely big count.");
        }
    }

}
