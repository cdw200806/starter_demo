package com.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class T7 extends Thread {

    volatile boolean b = true;

    public static void main(String[] args) throws Exception {

        ObjectInputStream o = new ObjectInputStream(new FileInputStream("a.txt"));
        Object conMap = o.readObject();

        long tt = Long.MAX_VALUE;
        System.out.println(tt + 1 == Long.MIN_VALUE);
        System.out.println(1);
        ConcurrentHashMap map = new ConcurrentHashMap(16);
        Object o = new Object();

        map.put(map, map);

        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put(map1, map1);

        System.out.println(map.equals(map1));
        System.out.println(map.hashCode());


        map.put(1, 1);
        //map.replace();


        for (int i = 0; i < 10; i++) {
            map.put(i * 32 + 1, 1);

        }
        map.put(1, 1);

        map.get(1);

        map.compute(1, (k, v) -> v);

        map.entrySet();


        Class<List> listClass = List.class;

        List<String> l = new ArrayList<>();
        System.out.println(1);

        List<String> ll = new LinkedList<>();


        List<? super ArrayList<String>> t = new ArrayList<List<String>>();
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
