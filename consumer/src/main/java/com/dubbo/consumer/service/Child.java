package com.dubbo.consumer.service;

/**
 * Author:zhangp
 * Date:2021/1/28 23:05
 * Description:
 */
public class Child extends UserService{

    public void sayHello(String str){
        System.out.println(str);
    }

    protected void shop(){

        System.out.println("购物！");

    }

    private void sayPrivate(String str){
        System.out.println(str);
    }



}
