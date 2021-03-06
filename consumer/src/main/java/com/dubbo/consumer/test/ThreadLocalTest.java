package com.dubbo.consumer.test;

public class ThreadLocalTest {

    public static ThreadLocal<String> parentMap = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        parentMap.set("我是父线程");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +  "-->" + parentMap.get());
            }
        }, "child");

        thread.start();
        System.out.println("main:" + parentMap.get());

    }

}
