package com.myproject.basic;

import static com.myproject.basic.Main.print;

import java.util.*;

public class CollectionsDemo implements Demo {
    public void test(){
        // List: well-ordered collection
        List<String> names = new ArrayList<>(); // Random access List
        names.add("Vasya Pupkin");
        List<String> otherNames = Arrays.asList("John Smith", "Mary Bloody", "Duku Mbanga");
        names.addAll(otherNames);
        for(String name : names){
            print("Name:", name);
        }

        List<Integer> numbers = Arrays.asList(1001, 2002, 3003);
        List<Integer> numbs2 = new LinkedList<>(); // Queue
        numbers.forEach(x -> numbs2.add(x * 10));
        print("Numbers: ");
        print(numbs2);

        // Map (Dict)
        Map<String, Integer> options = new HashMap<>();
        options.put("size", 10);
        options.put("weight", 5);
        options.put("color", 0xFF0000);
        for(String key: options.keySet()){
            print(key, options.get(key));
        }
        // Map: HashMap, TreeMap

        // Set: unique values, no order
        Set<Integer> idList = new HashSet<>();
        idList.addAll(Arrays.asList(111, 222, 333, 444, 222, 111));
        print("Set, values:");
        print(idList.toArray());
        // Set: HashSet, TreeSet

        // Dequeue ("double ended queue")
        Deque<String> commands = new LinkedList<>();
        commands.push("comm-1");
        commands.push("comm-2");
        commands.push("comm-3");
        Deque<String> copyComm = new ArrayDeque<>(commands);

        // pop
        while(! commands.isEmpty()) {
            print(commands.pop());
        }
        // poll
        print("Copy size:", copyComm.size());
        while(! copyComm.isEmpty()) {
            print(copyComm.pollLast());
        }

    }
}
