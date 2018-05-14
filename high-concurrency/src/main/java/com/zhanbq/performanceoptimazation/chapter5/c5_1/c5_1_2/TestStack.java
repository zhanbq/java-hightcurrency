package com.zhanbq.performanceoptimazation.chapter5.c5_1.c5_1_2;

public class TestStack {
  
  public static int count = 0;
  
  private void recursion(){
    count ++;
    recursion();
  }
  
  public static void main(String[] args) {
    try {
      new TestStack().recursion();
    } catch (Throwable e) {
        System.out.println("deep of stack is : "+count);
      e.printStackTrace();
    }
  }
}
