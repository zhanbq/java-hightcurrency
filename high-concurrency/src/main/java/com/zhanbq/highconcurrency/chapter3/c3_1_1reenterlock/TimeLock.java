package com.zhanbq.highconcurrency.chapter3.c3_1_1reenterlock;

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
  
  public static void main(String[] args) {
    TimeLock tl = new TimeLock();
    Thread t1 = new Thread(tl);
    Thread t2 = new Thread(tl);
    
    t1.start();
    t2.start();
    
  }
}
/**
 * 锁申请等待限时
 * 
 * 除了等待外部通知外,限时等待的方式也可以避免死锁.
 * 通常我们无法判断一个线程为什么迟迟拿不到锁.也许是因为死锁了,也许是
 * 因为产生了饥饿.但如果给定一个等待时间,让线程自动放弃 那么对系统来说是有意义的.
 * 我们可以使用trylock方法进行一次限时的等待.
 * 
 * 在这里tryLock()方法接收两个参数,一个表示等待时常,一个表示计时单位.
 * 如果超过五秒还没有得到锁,就返回false 如果获得所成功就返回true
 * 
 * 在本例中,由于占用锁的线程会持有锁长达六秒,故另一个线程无法再五秒的等待时间内获得锁,
 * 因此请求锁会失败
 * 
 * tryLock也可以不带参数直接运行.这种情况下,当前线程会尝试获得锁,如果锁违背其它线程占用,
 * 则会申请成功,并立即返回true.如果锁被其他线程占用,则当前线程不会进行等待,而是立即返回false.
 * 这种模式不会引起线程等待,因此也不会产生死锁.
 * 
 * 
 * 
 * 
 * 
 */
