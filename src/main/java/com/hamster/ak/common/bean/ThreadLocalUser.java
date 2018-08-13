package com.hamster.ak.common.bean;

import com.hamster.ak.api.User;

public class ThreadLocalUser {
  private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

  public static void setUser(User user) {
    threadLocal.set(user);
  }

  public static User getUser() {
    return threadLocal.get();
  }

}
