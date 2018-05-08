package com.zhanbq.highconcurrency.chapter2.deamon;

import com.zhanbq.highconcurrency.chapter2.deamon.DeamonDemo.DeamonT;

/**
 * 
 * @author o
 *  
 */
public class DeamonDemo {
  public static class DeamonT extends Thread{

    @Override
    public void run() {
      while (true) {
        System.out.println("I am alive");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    
  }
  
  public static void main(String[] args) throws InterruptedException {
    DeamonT t = new DeamonT();
    t.setDaemon(true); //设置为守护线程,必须在start之前设置.否则抛异常并被视为用户线程继续执行
    t.start();
    
    Thread.sleep(2000);
  }
}

/**
 * 守护线程是一种特殊的线程,就和它的名字一样,他是系统的守护者,
 * 在后台默默的完成一些系统性的服务,比如垃圾回收,JIT线程就可以理解为
 * 守护线程.
 * 与之相对应的用户线程,用户线程可以认为是系统的工作线程,他会完成这个程序应该要
 * 完成的业务操作.如果用户线程全部结束,这也意味着这个程序实际上无事可做了.
 * 守护线程要守护的对象已经不存在了,那么整个应用程序就自然应该结束了.
 * 因此当一个java应用内,只有守护线程时,java虚拟机就会自然退出.
 * 
 * 在上面的例子中,由于t1被设置为守护线程,系统中只有主线程main为用户线程,
 * 因此在main线程休眠2秒后退出是,整个程序也随之结束.但是如果不把线程t作为守护线程,
 * main线程结束后,t线程还是会不停的打印,永远不会结束.
 */
