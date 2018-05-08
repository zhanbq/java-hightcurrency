package com.zhanbq.highconcurrency.chapter3.reenterlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {
  
  public static ReentrantLock lock = new ReentrantLock();
  
  @Override
  public void run() {
    try {
      if(lock.tryLock(5,TimeUnit.SECONDS)){
        Thread.sleep(6000);
      }else{
        System.out.println("get lock failed");
      }
    } catch (Exception e) {

    }finally {
      if(lock.isHeldByCurrentThread()){
        lock.unlock();
      }
    }
  }

}
