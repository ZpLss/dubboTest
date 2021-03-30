package com.dubbo.consumer.test;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static ThreadLocal<String> parentMap = new InheritableThreadLocal<>();

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        int a = (1 << 29) -1;
        System.out.println(a);
        try {
            parentMap.set("我是父线程");
            for (int i = 0; i < 100;i++){
                Future future = executor.submit(new Task());
                System.out.println(future.get());
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
            System.out.println("main:" + parentMap.get());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        HashMap map = new HashMap();
        String str = new String();


    }

}
