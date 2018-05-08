package com.zhanbq.highconcurrency.chapter2.c2_7synchr;

public class AccountingSync implements Runnable {

  static AccountingSync instance = new AccountingSync();

  static int i = 0;


  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      synchronized (instance) {
        i++;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(instance);
    Thread t2 = new Thread(instance);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(i);


  }
}
/**
 * 关键字synchronized可以有多种用法,简单整理:
 * - 指定加锁的对象: 对给定对象加锁,进入同步代码前要获得给定对象的锁.
 * - 直接作用于实例方法: 相当于对当前实例加锁,进入同步代码前要获得当前实例的锁. 
 * - 直接作用于静态方法: 相当于对当前类加锁,进入同步代码块要获得当前类的锁.
 * 
 * 上面代码: 将synchronized作用于一个给定的对象instance.因此,每次当线程进入被synchronized
 * 包裹的代码段,都会要求请求instance实例的锁.
 * 如果当其他线程持有这把锁,那么新到 的 线程就必须等待.
 * 这样既保证每次只能有一个线程执行了i++操作.
 */
