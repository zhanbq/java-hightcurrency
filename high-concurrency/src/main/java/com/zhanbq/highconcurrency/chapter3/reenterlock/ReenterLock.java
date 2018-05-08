package com.zhanbq.highconcurrency.chapter3.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

  public static ReentrantLock lock = new ReentrantLock();

  public static int i = 0;

  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      lock.lock();
      try {
        i++;
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReenterLock tl = new ReenterLock();

    Thread t1 = new Thread(tl);
    Thread t2 = new Thread(tl);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(i);

  }
}

/**
 * 重入锁可以完全替代synchronized关键字.在jdk1.5的早期版本,重入锁的性能远远好于synchronized
 * 但从1.6开始,jdk在synchronized上做了大量的优化,是得两者的性能差距不大.
 * 
 * 重入锁使用 {@link java.util.concurrent.locks.ReentrantLock;}类来实现.
 * 
 * 上面试一段非常简单的重入锁实现案例.
 * 
 * 使用重入锁保护临界区i,确保多线程对i操作的安全性.从这段代码可以看到,与synchronized相比,
 * 重入锁有着现实的操作过程.
 * 
 * 开发人员必须手动指定何时加锁,何时释放锁.也正因为这样,重入锁对逻辑控制的灵活性要远远好于synchronized.
 * 
 * 但值得注意的事,在退出临界区是,必须记得释放锁,否则,其它线程就没有机会在访问临界区了.
 * 
 * 一个线程连续两次获得同一把锁是允许的.但是需要注意的是,
 * 如果同一个线程多次获得锁,那么在释放锁的时候,也必须释放相同的次数
 */
