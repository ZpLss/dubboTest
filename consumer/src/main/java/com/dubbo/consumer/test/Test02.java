package com.dubbo.consumer.test;

public class Test02 {

    public static volatile int count = 0;
    public static Object object = new Object();

    public static void main(String[] args) {

        Thread  a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        object.wait();
                        for (int i = 0; i < 10000; i++){
                            count++;
                        }
                        System.out.println("a:count-->" + count);
                    } catch (Exception   e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A");

        Thread  b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        object.notify();
                        for (int i = 0; i < 10000; i++){
                            count++;
                        }
                        System.out.println("b:count-->" + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B");

        a.start();
        b.start();
        System.out.println("count-->" + count);

    }

}
