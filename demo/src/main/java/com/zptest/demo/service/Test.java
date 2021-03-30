package com.zptest.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

public class Test {

    public static final ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        File file = new File("");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            
        }
        System.out.println(111);

        ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
        Executor executor;
        Object o = new Object();
        String s = new String("11");
        s.equals(s);
        HashMap map = new HashMap();
        map.put("qq", 22);
        Map map1 = Collections.synchronizedMap(map);


    }



}
