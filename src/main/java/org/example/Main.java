package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new MyCallable();

        for(int i = 0; i < 10; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }

        for(Future<String> fut : list){
            try {
                System.out.println(fut.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
