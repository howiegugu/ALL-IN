package com.guguhowie.other;

public class StaticDemo {

    private LockService lockService;

    public StaticDemo(LockService lockService) {
        this.lockService = lockService;
    }

    public void doSomething() {
        RedisLock.lock();
        System.out.println("dosomething");
        RedisLock.unlock();
    }

    static class RedisLock {
        public static void lock() {
        }

        public static void unlock() {
        }
    }
}
