package com.zhanbq.highconcurrency.chapter3.c3_1_4ReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
  private static Lock lock = new ReentrantLock();

  private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  private static Lock readLock = readWriteLock.readLock();

  private static Lock writeLock = readWriteLock.writeLock();

  private int value;

  public Object handleRead(Lock lock) throws InterruptedException {

    try {
      lock.lock(); // 模拟读操作
      System.out.println(Thread.currentThread().getName() + "-read start");
      Thread.sleep(1000); // 读操作的耗时越多,读写锁的优势就越明显
      System.out.println(Thread.currentThread().getName() + "-read end");
      return value;
    } finally {
      lock.unlock();
    }
  }

  public void handleWrite(Lock lock, int index) throws InterruptedException {

    try {
      lock.lock(); // 模拟写操作
      System.out.println(Thread.currentThread().getName() + "-write start");
      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + "-write end");
      value = index;
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    final ReadWriteLockDemo demo = new ReadWriteLockDemo();
    Runnable readRunnable = new Runnable() {
      public void run() {
        try {
          demo.handleRead(readLock);
          // demo.handleRead(lock);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Runnable writeRunnable = new Runnable() {
      public void run() {
        try {
          demo.handleWrite(writeLock, new Random().nextInt());
          // demo.handleWrite(lock, new Random().nextInt());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    for (int i = 0; i < 18; i++) {
      new Thread(readRunnable, "read-thread-" + i).start();
    }

    for (int i = 18; i < 20; i++) {
      new Thread(writeRunnable, "write-thread-" + i).start();
    }
  }
}
/**
 * 
 *      上述代码中,第24行和37行都模拟了一个非常耗时的操作,让线程耗时1秒钟. 
 * 它们分别对应读耗时和写耗时. 代码的第50和61行,分别是读线程和写线程.
 *      在这里,第50行使用读锁,第61行使用写锁. 
 * 第69~71行开启了18个读线程,第73~75行,开启两个写线程.
 *      由于这里使用了读写分离,因此读线程完全并行,而写会阻塞,
 * 因此 实际上这段代码运行大约2秒多就能结束(写线程之间实际上是 串行的). 
 *      如果使用第51行代替第50行,
 * 使用第61行代替第60行执行上述代码,
 *      即,
 * 使用普通的重入锁代替读写锁.那么所有的读和写之间都必须互相等待,因此整个程序执行时间将长达20多秒.
 */
