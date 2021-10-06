package org.example;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        int mess = new Random().nextInt(4);
        for (int i = 1;i<= mess;i++ ){
            System.out.println("I`m thread " + Thread.currentThread().getName() + " printing the " + i + " message");
        }
        Thread.sleep(2000);
        return "Thread " + Thread.currentThread().getName() + " has printed " + mess + " messages";
    }
}
