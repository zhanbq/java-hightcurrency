package com.zhanbq.highconcurrency.chapter2.c2_2_2stopAndInterrupt;

public class InterruptTest3 {


  public static void main(String[] args) throws InterruptedException {


    Thread t1 = new Thread(new Runnable() {

      @Override
      public void run() {
        while (true) {
          if(Thread.currentThread().isInterrupted()){
            System.out.println("interrupt");
            break;
          }
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            System.out.println("线程sleep时设置中断");
            //设置中断状态
            Thread.currentThread().interrupt();
          }
          Thread.yield();
        }

      }
    });
    t1.start();
    Thread.sleep(2000);
    t1.interrupt();
  }

}
