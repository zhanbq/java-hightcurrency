package com.zhanbq.highconcurrency.chapter2.c2_2_6joinAndYield;

public class JoinMain {

  public volatile static int i = 0;

  public static class AddThread extends Thread{

    @Override
    public void run() {
      for(i= 0; i <10000000; i++);
    }
    
  }
  
  
  public static void main(String[] args) throws InterruptedException {
    AddThread addThread = new AddThread();
    addThread.start();
    addThread.join();
    System.out.println(i);
  }
/**
 * 主函数中,如果不适用join等待addthread,那么得到的i很可能是0
 * 或者一个很小的数字.因为addthread还没开始执行,i的值就已经被输出.
 * 但在使用了join方法后,表示主线程愿意等待addthread执行完毕,跟着addthread一起往前走,
 * 故join返回时,addthread已经执行完毕,故i总是10000000
 */


}
