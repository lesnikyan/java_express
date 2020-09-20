package com.myproject.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.myproject.basic.Main.*;

public class Methods implements Demo {

    public void test(){
        printNumbers(new int[]{11, 22, 33});
        printNumbers(" #*# ", new int[]{55, 66, 77});
    }

    // Method can return value: any type
    private String classInfo(){
        return this.getClass().getName();
    }

    // Method may not return value: void
    private void printNumber(int num){
        System.out.println(num);
    }

    // Method can take variable list args
    // They should have the same type
    private void printNumbers(int... nums){
        printNumbers(", ", nums);
    }

    // Method can be overloaded: same name with different args
    // Varargs should be placed in the last position
    private void printNumbers(String delim, int... nums){
        List<String> strNums = new ArrayList<>();
        Arrays.stream(nums).forEach(x -> strNums.add(Integer.toString(x)));
        String str = String.join(delim, strNums);
        print(str);
    }

    // No default args.

    // No unnecessary args

    // No named args
}
