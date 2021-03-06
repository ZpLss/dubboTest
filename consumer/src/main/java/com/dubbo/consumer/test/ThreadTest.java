package com.dubbo.consumer.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "thread_02");
        thread1.start();


        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "thread03";
            }
        });
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("thread_01");
        }
    }

}
