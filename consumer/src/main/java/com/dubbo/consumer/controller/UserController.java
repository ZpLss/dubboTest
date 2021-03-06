package com.dubbo.consumer.controller;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:zhangp
 * Date:2021/1/28 22:56
 * Description:
 */
public class UserController {

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void say(){

        ConcurrentHashMap map = new ConcurrentHashMap(20);
        map.put("aa","aa");


    }
}
