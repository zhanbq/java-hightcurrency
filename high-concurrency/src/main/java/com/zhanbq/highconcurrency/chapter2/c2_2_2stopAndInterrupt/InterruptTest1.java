package com.zhanbq.highconcurrency.chapter2.c2_2_2stopAndInterrupt;

public class InterruptTest1 {
  
  public static void main(String[] args) throws InterruptedException {
    
    
    Thread t1 = new Thread(new Runnable() {
      
      @Override
      public void run() {
        while (true) {
          System.out.println("yield");
          Thread.yield();
        }
        
      }
    });
    t1.start();
    Thread.sleep(2000);
    t1.interrupt();
  }
}
