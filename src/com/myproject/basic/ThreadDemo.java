package com.myproject.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static com.myproject.basic.Main.*;

public class ThreadDemo implements Demo {
    public void test(){
        // Thread
        testThread();

        // Runnable
        testRunnable();

        // Callable
        testCallable();
    }

    // ---- Callable interface block ---- //
    private void testCallable(){

        print("Test of Callable, Future");

        ExecutorService exec = Executors.newCachedThreadPool();
        class MyResult {
            public int x = 0;
        }
        class ResultMaker implements Callable<MyResult>, SafelySleep{
            private int number;

            public ResultMaker(int number){
                this.number = number;
            }

            @Override
            public MyResult call() {
                sleep(2000);
                MyResult res = new MyResult();
                res.x = number;
                return res;
            }
        }
        // make tasks
        List<ResultMaker> tasks = Arrays.asList(
                new ResultMaker(10),
                new ResultMaker(20),
                new ResultMaker(30)
        );

        SafelySleep waiter = new SafelySleep() {};
        // run tasks
        try {
            List<Future<MyResult>> futList = exec.invokeAll(tasks);
            exec.shutdown();

            while(! exec.isTerminated()){
                // waiting, doesn't repeat loop
                print("waiting finished");
                waiter.sleep(50);
            }
            // get and use results
            for(Future<MyResult> fut: futList){
                if(fut.isDone()){
                    MyResult res = fut.get();
                    print("MyResult:", res.x);
                }
            }
            print("Test Callable finished;");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    int ppLineCount = 0;
    public synchronized void pp(Object x){
        if(ppLineCount >= 50){
            System.out.print("\n");
            ppLineCount = 0;
        }
        String str = x.toString();
        System.out.print(str);
        ppLineCount += str.length();
    }

    // ---- Runnable interface block ---- //

    /**
     * Race through tunnel
     */
    private void testRunnable(){
        print("Test of Runnable");
        SafelySleep waiter = new SafelySleep() {};

        List<RaceRun> runners = new ArrayList<>();
        char startName = 'A';
        // 26 members / threads: A - Z
        for(short i=0; i < 26; ++i){
            char[] oneCharName = new char[]{(char)(startName + i)};
            String memberName = new String(oneCharName);
            runners.add(new RaceRun(memberName));
        }

        // 5 tracks
        ExecutorService exec = Executors.newFixedThreadPool(5);
        runners.forEach((RaceRun runner) -> exec.execute(runner));
        exec.shutdown(); // stop adding
        waiter.sleep(2500); // wait here
        exec.shutdownNow(); // stop threads

        print("\nTest Runnable finished;");
    }

    class RaceRun extends Counter implements SafelySleep, Runnable {

        private String name;

        public RaceRun(String name){
            n = 5; // n steps by each race member
            this.name = name;
        }

        @Override
        public void run() {
            for(; n > 0; --n){
                pp(name+n+" ");
                sleep(50); // time of 1 step
            }
        }
    }

    class Counter {
        protected int n = 0;
    }

    // ------------ Thread class block ------------- //

    private void testThread(){
        CounterThread counterThread = new CounterThread(5);
        counterThread.start();
        print("Test Thread: counter started");
        try {
            counterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Test Thread finished;");
    }
}

class CounterThread extends Thread {

    private int count;

    public CounterThread(int count){
        this.count = count;
    }

    public void run(){
        for(int i = 0; i < count; ++i){
            try {
                print("Iteration:", i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        print("End of thread.");
    }
}


interface SafelySleep {
    default void sleep(int msec){
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
