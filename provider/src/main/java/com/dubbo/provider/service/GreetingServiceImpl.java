package com.dubbo.provider.service;

import com.alibaba.fastjson.JSON;
import com.dubbo.sdk.model.PoJo;
import com.dubbo.sdk.model.Result;
import com.dubbo.sdk.service.GreetingService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * Author:zhangp
 * Date:2021/2/4 22:53
 * Description:
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String company = RpcContext.getContext().getAttachment("company");

        return "Hello " + name + " " + company;
    }

    @Override
    public Result<String> testGeneric(PoJo poJo) {
        Result<String> result = new Result<>();
        result.setSuccess(true);
        try {
            result.setData(JSON.toJSONString(poJo));
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
