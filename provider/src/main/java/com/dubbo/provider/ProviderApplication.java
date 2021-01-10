package com.dubbo.provider;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Author:zhangp
 * Date:2021/1/9 15:11
 * Description:
 */
public class ProviderApplication {

    public static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args)  throws Exception{
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //启动spring ioc后，不要退出
        int read = System.in.read();

//        Thread.sleep(1000000000);
    }
}
