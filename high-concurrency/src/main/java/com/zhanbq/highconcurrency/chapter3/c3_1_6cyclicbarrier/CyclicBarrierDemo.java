package com.zhanbq.highconcurrency.chapter3.c3_1_6cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


  public static class Soldier implements Runnable {

    private String soldier;
    private final CyclicBarrier cyclic;

    public Soldier(CyclicBarrier cyclic, String soldier) {
      this.cyclic = cyclic;
      this.soldier = soldier;
    }

    @Override
    public void run() {

      try {
        cyclic.await();// 等待所有士兵集合

//        System.out.println("士兵集合完毕,开始工作");
        dowork();
        cyclic.await();// 等待所有士兵完成任务
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    private void dowork() {
      try {
        Thread.sleep(Math.abs(new Random().nextInt() % 10000));
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      System.out.println(soldier + ": 任务完成");
    }

  }

  public static class BarrierRun implements Runnable {

    boolean flag;
    int N;

    public BarrierRun(boolean flag, int N) {
      this.flag = flag;
      this.N = N;
    }

    @Override
    public void run() {
      if(flag){
        System.out.println("司令 : [士兵 "+N+"个, 任务完成]");
      }else {
        System.out.println("司令 : [士兵 "+N+"个, 集合完毕]");
        flag = true;
      }
      
    }

  }
  
  public static void main(String[] args) {
    final int N = 10;
    Thread[] allSodiers = new Thread[N];
    boolean flag = false;
    
    CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
    //设置屏障点,主要是为了执行这个方法
    System.out.println("集合队伍!");
    for (int i = 0; i < N; i++) {
      System.out.println("士兵 "+i+" 报道!");
      allSodiers[i] = new Thread(new Soldier(cyclic, "士兵 "+i));
      allSodiers[i].start();
    }
  }
}
