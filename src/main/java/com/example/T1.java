package com.example;

public class T1 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        T1 t1 = new T1();
        t1.start();
        //     t1.join();

        //Thread.currentThread().join();


        System.out.println("看下谁先执行");
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
