package com.zhanbq.performanceoptimazation.CH3.javatuning.ch3.stringappend;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ���ַ������� StringBuffer ��StringBuilder�Ƚ�
 * @author Administrator
 *
 */
public class TestStringBuffer {
	static int CIRCLE=500000;
	
	//@Test
	public void testStringPlus() {
		String str="";
		long begintime=System.currentTimeMillis();
	     
	     for(int i=0;i<CIRCLE;i++){
	    	 str=str+i;
	    	 //str+=i;
	     }
		long endtime=System.currentTimeMillis();
		
		System.out.println("testStringPlus ����:"+(endtime-begintime)+" ms");
	}
	
	//@Test
	public void testStringConcat() {
	    long startTime = System.currentTimeMillis();
	    String result="";
	    int c=CIRCLE;///10;
	    for(int i=0;i<CIRCLE;i++){
	    	result=result.concat(String.valueOf(i));
	    } 
	    long endTime = System.currentTimeMillis();
	    System.out.println("testStringConcat ���� ��"+(endTime-startTime));
	}
	
	@Test
	public void testStringBuffer() {
		StringBuffer sb=new StringBuffer();
		long begintime=System.currentTimeMillis();
	     
	     for(int i=0;i<CIRCLE;i++){
	    	 sb.append(i);
	     }
	     sb.toString();
		long endtime=System.currentTimeMillis();
		
		System.out.println("testStringBuffer ����:"+(endtime-begintime)+" ms");
	}

	@Test
	public void testStringBuilder() {
		StringBuilder sb=new StringBuilder();
		long begintime=System.currentTimeMillis();
	     
	     for(int i=0;i<CIRCLE;i++){
	    	 sb.append(i);
	     }
	     sb.toString();
		long endtime=System.currentTimeMillis();
		
		System.out.println("testStringBuilder ����:"+(endtime-begintime)+" ms");
	}
	
	@Test
	public void testStringBuffer10() {
		StringBuffer sb=new StringBuffer(5888890);
		long begintime=System.currentTimeMillis();
	     for(int i=0;i<CIRCLE;i++){
	    	 sb.append(i);
	     }
	     sb.toString();
		long endtime=System.currentTimeMillis();
		System.out.println("testStringBuffer10 ����:"+(endtime-begintime)+" ms");
	}

	@Test
	public void testStringBuilder10() {
		StringBuilder sb=new StringBuilder(5888890);
		long begintime=System.currentTimeMillis();
	     
	     for(int i=0;i<CIRCLE;i++){
	    	 sb.append(i);
	     }
	     sb.toString();
		long endtime=System.currentTimeMillis();
		
		System.out.println("testStringBuilder10  ����:"+(endtime-begintime)+" ms");
	}
}
