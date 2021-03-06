package com.dubbo.consumer;

import com.dubbo.sdk.service.GreetingService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author:zhangp
 * Date:2021/1/9 15:09
 * Description:
 */
public class ConsumerApplication {

    public static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("sss");

        //同步调用
        RpcContext.getContext().setAttachment("company", "alibaba");
        GreetingService greetingService = context.getBean(GreetingService.class);
//        String wahaha = greetingService.sayHello("wahaha");
//        System.out.println(wahaha);
//        Result<String> result = greetingService.testGeneric(new PoJo("1", "xiaomei"));
//        System.out.println(result.getData());


        //异步调用
        System.out.println(greetingService.sayHello("nihao!"));
        Future<Object> future = RpcContext.getContext().getFuture();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        HashMap map = new HashMap();
        map.put("aa", "bb");





    }



}
