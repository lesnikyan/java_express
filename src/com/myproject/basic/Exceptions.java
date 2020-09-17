package com.myproject.basic;

// https://www.tutorialspoint.com/java/java_exceptions.htm

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.myproject.basic.Main.print;

public class Exceptions {

    Logger logger = Logger.getLogger(Exceptions.class.getName());

    private void log(String msg){
        logger.log(Level.WARNING, msg);
    }

    public void test(){
        // System exceptions
        try {

            zeroDiv(1, 2, 0, 4);
        } catch (ArithmeticException ex) {
            log("Exception error: " + ex.getMessage());
        }

        // Custom exception

    }

    public void zeroDiv(int... nums) throws ArithmeticException {
        int res = 0;
        for(int x : nums){
            res += 100 / x;
        }
        print(res);
    }

//    public String

}
