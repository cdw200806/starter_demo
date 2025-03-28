package com.example;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class T3 implements Runnable {

    public static void main(String[] args) {

        T3 t1 = new T3();
        Thread thread = new Thread(t1);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("MTT");

 
    }
}
