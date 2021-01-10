package com.dubbo.consumer;

import com.dubbo.sdk.model.User;
import com.dubbo.sdk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        UserService bean = context.getBean(UserService.class);
        String s = bean.sayHello();
        System.out.println("******************************************");
        System.out.println(s);
        logger.info(s + "******************************");
        User user = bean.get("1");
        System.out.println("******************************************");
        System.out.println(user);
    }



}
