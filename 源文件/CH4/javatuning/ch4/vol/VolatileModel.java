package javatuning.ch4.vol;

import org.junit.Test;

public class VolatileModel {
	 public class MyThread extends Thread{
		 private   boolean stop = false;  
		 public void stopMe(){
			 stop=true;
		 }
		 
         public void run() {  
             int i = 0;  
             while (!stop) { 
                 i++;  
             }
             System.out.println("Stop Thread");  
         }  
	 }
	 
	 @Test
	 public void test() throws InterruptedException{
		 MyThread t = new MyThread();  
		 t.start(); 
		 Thread.sleep(1000);
		 t.stopMe();
		 Thread.sleep(1000);
	 }
}
