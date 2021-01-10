package com.dubbo.provider.service;

import com.dubbo.sdk.model.User;
import com.dubbo.sdk.service.UserService;

/**
 * Author:zhangp
 * Date:2021/1/9 16:44
 * Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "Hello dubbo";
    }

    @Override
    public User get(String id) {
        User user = new User();
        user.setId("1");
        user.setAge(18);
        return user;
    }
}
