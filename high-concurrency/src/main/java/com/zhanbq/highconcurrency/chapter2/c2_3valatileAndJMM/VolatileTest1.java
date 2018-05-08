package com.zhanbq.highconcurrency.chapter2.c2_3valatileAndJMM;

/**
 * volatitle 保证线程间变量的可见性,无法保证原子性操作
 * @author o
 *
 */
public class VolatileTest1 {
  public static volatile int i = 0;

  public static class PlusTask implements Runnable {

    @Override
    public synchronized void run() {
      for (int k = 0; k < 10000; k++) {
        i++;
      }

    }

  }

  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[10];
    for(int i = 0 ;i<10;i++){
      threads[i] = new Thread(new PlusTask());
      threads[i].start();
    }
    for(int i = 0 ; i<10;i++){
      threads[i].join();
    }
    System.out.println(i);
  }
  
  
}
