package com.myproject.basic;

import static com.myproject.basic.Main.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

public class Functions implements Demo {
    public void test(){
        // Lambda functions (Java 8)
        // function is implementation of Functional Interface
        // Functional Interface - interface with just 1 non-implemented method

        // Function: T func(R),
        Function<Integer, String> strNums = x -> repeat(Integer.toString(x), x);
        // call `apply`
        print(strNums.apply(3));
        print(strNums.apply(8));

        // Supplier: T func()
        Supplier<String> sup  = () -> "Hello!";
        // call `get`
        print("Supply:", sup.get());

        // Predicate: Boolean(T)
        IntPredicate more10 = x -> x > 10;

        // Consumer: Void func(T)
        List<Integer> consResult = new ArrayList<>();
        Consumer<Integer> cons = x -> consResult.add(x);
        // use in stream
        List<Integer> conSource = Arrays.asList(1, 12, 5, 33, 7, 42, 51);
        conSource.forEach(cons); // use consumer

        // Stream framework (Java 8)
        // IntStream.of(1, 2, 3, 4, 5);
        IntStream streamRes = consResult.stream()
                .mapToInt(x -> x + 2) // use lambda (Function)
                .filter(more10); // use Predicate
        print("IntStream:");
        print(streamRes.toArray());
    }
}
