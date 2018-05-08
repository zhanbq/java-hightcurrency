package com.zhanbq.highconcurrency.chapter3.c3_1_2condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {

  public static ReentrantLock lock = new ReentrantLock();
  public static Condition condition = lock.newCondition();
  
  @Override
  public void run() {
    try {
      lock.lock();
      System.out.println("await");
      condition.await();
      System.out.println("thread is going on");
    } catch (Exception e) {
    } finally {
      lock.unlock();
    }

  }
  
  public static void main(String[] args) throws InterruptedException {
    ReenterLockCondition tl = new ReenterLockCondition();
    
    Thread t1 = new Thread(tl);
    t1.start();
    Thread.sleep(2000);
    System.out.println("main get lock");
    lock.lock();
    Thread.sleep(2000);
    condition.signal();
    System.out.println("t1 signal ");
    lock.unlock();
    
  }
}
