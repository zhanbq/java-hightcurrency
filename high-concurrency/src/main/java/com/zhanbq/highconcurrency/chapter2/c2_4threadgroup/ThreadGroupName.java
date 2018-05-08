package com.zhanbq.highconcurrency.chapter2.c2_4threadgroup;

public class ThreadGroupName implements Runnable {

  @Override
  public void run() {
    String groupAndName = Thread.currentThread().getThreadGroup().getName() + " - "
        + Thread.currentThread().getName();
    while (true) {
      System.out.println("i am "+groupAndName);
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    ThreadGroup threadGroup = new ThreadGroup("printGroup");
    
    Thread t1 = new Thread(threadGroup,new ThreadGroupName(), "T1");
    Thread t2 = new Thread(threadGroup,new ThreadGroupName(), "T2");
    
    t1.start();
    t2.start();
    /*
     * activeCount 可以获得活动线程的总数,但是由于线程是动态的,
     * 因此这个值只是一个估计值,无法确定精确
     */
    System.out.println(threadGroup.activeCount());
    /*
     * list方法可以打印这个线程组所有的线程信息,对调试一定有帮助
     */
    threadGroup.list();
    threadGroup.stop();
  }
  
  
}
