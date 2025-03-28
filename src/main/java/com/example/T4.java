package com.example;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.locks.Condition;

public class T4 {


    public static void main(String[] args) {


        //软-->不够时回收，如大文件缓存
        //弱-->如entry对 threadLocal 只要gc就回收。 gt为了自动回收。  但是value要手动，依赖jdk自动回收不是最佳实践
        //虚-->比finalize 更可靠，无法通过虚引用get对象。知识在finalize之后，回收内存之前，给block在队列上的线程唤醒。去执行一些逻辑。比如对外内存的释放.DirectByteBuffer中的byteBufeer对象被回收后自动执行CLean类的unsafe.freememory.

//        package java.util.concurrent.locks;
//        void signal() {
//            notEmpty.signalAll();
//        }
//
//        void await() throws InterruptedException {
//            notEmpty.await();
//        }
////
//
//        private final Condition notEmpty;
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> t = new PhantomReference<>(new Object(), queue);


        Thread demon1 = new Thread(() -> {
            try {
                Reference blocktoGetRef = queue.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("getSuccess");
            try {

                //由于设置了守护，主线程结束时，子线程被强制退出。
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        demon1.setDaemon(true);
        demon1.start();


        //先抛出OOM，然后触发gc。最后结束了
        byte[] test = new byte[1024 * 1024 * 9];
    }
}
