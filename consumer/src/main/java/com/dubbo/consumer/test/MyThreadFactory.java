package com.dubbo.consumer.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {

                return "Hello Factory";
            }
        });
        Thread thread = new Thread(futureTask);
        return thread;
    }
}
