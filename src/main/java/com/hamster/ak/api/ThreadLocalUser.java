package com.hamster.ak.api;

/**
 * 使用 ThreadLocal 保证每个线程都持有当前user副本
 */
public class ThreadLocalUser {
    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        threadLocal.set(user);
    }

    public static User getUser() {
        return threadLocal.get();
    }
}
