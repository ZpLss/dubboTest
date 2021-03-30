package com.dubbo.consumer.test;

import java.util.concurrent.Callable;

public class Task implements Callable {
    @Override
    public Object call() throws Exception {
        return "Hello";
    }
}
