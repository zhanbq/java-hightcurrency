package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.jvmlocks;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSyncObject {
	public static Object lock=new Object();
	
	public static final int CIRCLE=10000000;
	@Test
	public void test() {
		long begintime=System.currentTimeMillis();
		for(int i=0;i<CIRCLE;i++){
			synchronized(lock){
				
			}
		}
		long endtime=System.currentTimeMillis();
		System.out.println("sync in loop:"+(endtime-begintime));
	}
	
	@Test
	public void test1() {
		long begintime=System.currentTimeMillis();
		synchronized(lock){
		for(int i=0;i<CIRCLE;i++){
				
			}
		}
		long endtime=System.currentTimeMillis();
		System.out.println("sync out loop:"+(endtime-begintime));
	}
	
	public void demoMethod(){
		synchronized(lock){
			//do sth.
		}
		//����������Ҫ��ͬ���Ĺ��������ܺܿ�ִ�����
		synchronized(lock){
			//do sth.
		}
	}

}
