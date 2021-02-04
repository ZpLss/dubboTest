package com.dubbo.sdk.service;

import com.dubbo.sdk.model.PoJo;
import com.dubbo.sdk.model.Result;

/**
 * Author:zhangp
 * Date:2021/2/4 22:26
 * Description:
 */
public interface GreetingService {

    String sayHello(String name);

    Result<String> testGeneric(PoJo poJo);


}
