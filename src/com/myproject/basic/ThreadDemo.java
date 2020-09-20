package com.myproject.basic;

import static com.myproject.basic.Main.*;

public class ThreadDemo implements Demo {
    public void test(){
        CounterThread counterThread = new CounterThread(5);
        counterThread.start();
        print("Test: counter started");
        try {
            counterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Test: counter finished");
    }
}

class CounterThread extends Thread {

    private int count;

    CounterThread(int count){
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