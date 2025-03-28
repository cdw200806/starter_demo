package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T5 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        Callable testCDL = () -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "count down，计数还剩下：" + countDownLatch.getCount());
            return null;
        };
        for (int i = 0; i < 9; i++) {
            executorService.submit(testCDL);
        }
        countDownLatch.await();
        System.out.println("等待结束");
        executorService.shutdown();
    }
}
