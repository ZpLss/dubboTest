package com.dubbo.consumer.test;

import java.util.concurrent.ConcurrentHashMap;

public class ListTest {

    public static int a = 0;
    public static void main(String[] args) {

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("aa", "aa");
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = 2;
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(a);
//            }
//        });
//
//        thread.start();
//        thread2.start();

    }



}
