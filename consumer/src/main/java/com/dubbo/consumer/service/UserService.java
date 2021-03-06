package com.dubbo.consumer.service;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author:zhangp
 * Date:2021/1/28 22:56
 * Description:
 */
public class UserService{
    public void sayHello(String str){
        System.out.println(str);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        int[] arr = new int[]{1,4};
        Collections.sort(arrayList);

    }

    protected void shop(){

        System.out.println("购物！");

    }

    private void sayPrivate(String str){
        System.out.println(str);
    }


}
