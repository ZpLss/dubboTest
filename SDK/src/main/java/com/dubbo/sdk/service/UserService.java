package com.dubbo.sdk.service;

import com.dubbo.sdk.model.User;

/**
 * Author:zhangp
 * Date:2021/1/9 16:13
 * Description:
 */
public interface UserService {

    public String sayHello();

    public User get(String id);
}
