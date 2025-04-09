package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class T7 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        ConcurrentHashMap map = new ConcurrentHashMap(4);
        Object o = new Object();
        map.put(null, 1);


        Class<List> listClass = List.class;

        List<String> l = new ArrayList<>();
        System.out.println(1);
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
