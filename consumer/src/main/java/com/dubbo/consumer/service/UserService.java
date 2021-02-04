package com.dubbo.consumer.service;

/**
 * Author:zhangp
 * Date:2021/1/28 22:56
 * Description:
 */
public class UserService {
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
