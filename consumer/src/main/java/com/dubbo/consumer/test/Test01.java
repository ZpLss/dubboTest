package com.dubbo.consumer.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
        lock.tryLock();
        try {
            lock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.isLocked();

        LockSupport.park();




    }



}
