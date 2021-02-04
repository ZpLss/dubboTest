package com.dubbo.sdk.service;

import java.util.concurrent.CompletableFuture;

/**
 * Author:zhangp
 * Date:2021/2/4 22:47
 * Description:
 */
public interface GreetingServiceAsync {

    CompletableFuture<String> sayHello(String name);

}
