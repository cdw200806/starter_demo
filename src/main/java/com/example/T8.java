package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T8 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap map = new ConcurrentHashMap(4);
        map.put(1, 1);
        Callable callable = () -> {
            System.out.println(11111);
            while (true) {
                map.compute(1, (k, v) -> v);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask futureTask = new FutureTask<>(callable);
        executorService.submit(futureTask);
        System.out.println(22222);
        while (true) {
            map.put(1, 1);
        }
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("testMt");
    }
}
