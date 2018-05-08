package com.zhanbq.highconcurrency.chapter2.c2_6priority;

public class PriorityDemo {

  public static class HightPriority extends Thread {
    static int count = 0;

    @Override
    public void run() {
      while (true) {
        synchronized (PriorityDemo.class) {
          count++;
          if (count > 10000000) {
            System.out.println("HightPriority is complete");
            break;
          }
        }
      }
    }

  }

  public static class LowPriority extends Thread {
    static int count = 0;

    @Override
    public void run() {
      while (true) {
        synchronized (PriorityDemo.class) {
          count++;
          if (count > 10000000) {
            System.out.println("LowPriority is complete");
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    HightPriority hight = new HightPriority();
    LowPriority low = new LowPriority();
    hight.setPriority(Thread.MAX_PRIORITY);
    low.setPriority(Thread.MIN_PRIORITY);
    low.start();
    hight.start();
  }
}

/**
 * java中的线程可以有自己的优先级.不过这只是一个概率问题. 如果运气不好,高优先级的线程可能也会抢占失败. 由于线程优先级调度和底层操作系统由密切的关系,在各个平台上表现不一,
 * 并且这种优先级产生的后果也可能不容易预测,无法精准控制.
 * 
 * 因此在要求严格的场合,还是需要自己在应用层解决线程调度的问题.
 * 
 * 以上述代码为例,高优先级的线程在大部分情况下,都会首先完成任务,但并不是所有情况都是这样
 */
