package javatuning.ch5.jvmpara;

import java.util.HashMap;

/**
-verbose:gc 
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintGCTimeStamps
-XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=18
-XX:+PrintHeapAtGC
-XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime
 *-Xloggc:C:\gc.log
 *
 *
 */
public class GetGCInfo {
	public static class MyThread extends Thread{
		HashMap map=new HashMap();
		@Override
		public void run(){
			try{
				while(true){
					if(map.size()*512/1024/1024>=40){
						map.clear();
						System.out.println("clean map");
					}
					byte[] b1;
					for(int i=0;i<50;i++){
						b1=new byte[512];
						map.put(System.nanoTime(), b1);
					}
					Thread.sleep(1);
				}
			}catch(Exception e){
				
			}
		}
	}
	public static void main(String args[]){
		MyThread t=new MyThread();
		t.start();
	}
}
