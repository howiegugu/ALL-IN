package com.guguhowie.other;

public class LockService {

    public void lock() {

        StaticDemo.RedisLock.lock();
    }

    public void unlock() {

        StaticDemo.RedisLock.unlock();
    }
}
