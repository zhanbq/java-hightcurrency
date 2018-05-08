package com.zhanbq.highconcurrency.chapter2.c2_7synchr;

public class AccountingVo1 implements Runnable {

  static AccountingVo1 instance = new AccountingVo1();
  static volatile int i = 0;

  public static void increase(){
    i++;
  }
  
  @Override
  public void run() {
    for(int j = 0 ; j<10000000;j++){
      increase();
    }
  }
  
  public static void main(String[] args) throws InterruptedException{
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
 * 上面的代码演示了一个计数器,两个线程同时对i进行累加操作,
 * 各执行10000000次.我们希望执行结果当然是最终i的值可以达到20000000,
 * 但事实并非总是如此.
 * 如果你多执行几次,你会发现,在很多是胡,i的最终值会小于20000000.
 * 这就是因为两个线程同时对i进行了写入时,其中一个线程的结果会覆盖另一个(虽然
 * 这个时候i被声明为volatile变量)
 * 
 * 这就是多线程不安全的恶果,
 * 例如
 * 线程1和线程2同事读取了i为0时,并个自计算得到1, 并先后写入这个结果, 因此
 * 虽然i++被执行了两次,但实际i的值只增加了1.
 * 
 * 要从根本上解决这个问题,我们就必须保证对个线程在堆i进行操作室完全同步.
 * 也就是说,当线程a在写入时,线程b不仅不能写,同时也不能读.因为线程a写完之前,线程b读取
 * 的一定是一个过期的数据.
 * java中提供了一个重要的关键字synchronized来实现这个功能
 */

