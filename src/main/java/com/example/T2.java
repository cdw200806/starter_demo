package com.example;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class T2 implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        T2 t1 = new T2();
        //线程池 eservice . 工具类es
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //线程池提交任务返回的是Future.
        Future<String> h1 = executorService.submit(t1);
        System.out.println(h1.get());
        //线程池不shutdown主线程一直在跑
        executorService.shutdown();
        ReentrantLock lock = new ReentrantLock();


        //t1除了直接扔给线程池submit。 也可以用FutureTask包装一下。变成了Runnable
        FutureTask<String> h2 = new FutureTask<>(t1);
        //传给线程创建的参数就像runnable一样了
        Thread ttt = new Thread(h2);
        ttt.start();
        //FutureTask 既实现了Future接口，也实现了Runnable接口。所以能阻塞到获取结果。
        System.out.println(h2.get());

    }

    @Override
    public String call() throws Exception {
        System.out.println("123");
        return "testMt";
    }
}
