package com.zhanbq.highconcurrency.chapter3.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {

  public static ReentrantLock lock1 = new ReentrantLock();

  public static ReentrantLock lock2 = new ReentrantLock();

  int lock;

  public IntLock(int lock) {
    this.lock = lock;
  }

  @Override
  public void run() {
    try {
      if (lock == 1) {
        lock1.lockInterruptibly(); // 请求锁,此方法可以对中断进行相应的申请动作,即在等待所的过程中,可以响应中断
        Thread.sleep(500);
        lock2.lockInterruptibly();
      } else {
        lock2.lockInterruptibly();
        Thread.sleep(500);
        lock1.lockInterruptibly();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (lock1.isHeldByCurrentThread()) {
        lock1.unlock();
      }
      if (lock2.isHeldByCurrentThread()) {
        lock2.unlock();
      }

      System.out.println(Thread.currentThread().getId() + ": 线程退出");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    IntLock r1 = new IntLock(1);
    IntLock r2 = new IntLock(2);

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
//    Thread.sleep(2000); //解开此注释不会造成死锁
    t2.start();

    Thread.sleep(1000);
    // 中断其中一个线程,解除之前的死锁
    t2.interrupt();

  }
}

/**
 * 除了使用上的灵活性外,重入锁还提供了一些高级功能. 比如,重入锁可以提供中断处理的能力.
 * 
 * 中断响应
 * 
 * 线程t1和t2启动后,t1先占用lock1,在占用lock2;t2先占用lock2,再请求lock1.
 * 因此,很容易形成t1和t2之前的相互等待(死锁).在这里,对锁的请求,同意使用lockInterrputibly()方法.
 * 这是一个可以对中断进行相应的锁神情动作,即在等在锁的过程中,可以响应中断.
 * 
 * 当代码54行,主线程main处于休眠,此时,这两个线程处与死锁的状态,在代码的56行,由于t2线程被中断,
 * t2对放弃对lock1的申请,同时释放已经获得的lock2.这个操作导致t1线程可以顺利的得到lock2而继续进行下去.
 * 
 * 
 */
