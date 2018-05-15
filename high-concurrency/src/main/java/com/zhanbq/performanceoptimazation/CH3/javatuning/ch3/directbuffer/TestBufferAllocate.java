package com.zhanbq.performanceoptimazation.CH3.javatuning.ch3.directbuffer;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * Ƶ�����ڴ����
 * ˵��  ���������directbuffer�Ĵ��۱Ƚϴ�
 * @author Administrator
 *
 */
public class TestBufferAllocate {

	private void monDirectBuffer() throws ClassNotFoundException, Exception, NoSuchFieldException{
		Class c = Class.forName("java.nio.Bits");
		Field maxMemory = c.getDeclaredField("maxMemory");  
		maxMemory.setAccessible(true);  
		Field reservedMemory = c.getDeclaredField("reservedMemory");  
		reservedMemory.setAccessible(true);  
		synchronized (c) {  
		    Long maxMemoryValue = (Long)maxMemory.get(null);  
		    Long reservedMemoryValue = (Long)reservedMemory.get(null);  
		    System.out.println("maxMemoryValue:"+maxMemoryValue);
		    System.out.println("reservedMemoryValue:"+reservedMemoryValue);
		} 
	}
	
	@Test
	public void testDirectAllocate() throws Exception{
		long starttime=System.currentTimeMillis();
		for(int i=0;i<20000;i++){
			ByteBuffer b=ByteBuffer.allocateDirect(1000);
			monDirectBuffer();
		}
		long endtime=System.currentTimeMillis();
		System.out.println("testDirectAllocate:"+(endtime-starttime));
	}
	
	@Test
	public void testBufferAllocate() {
		long starttime=System.currentTimeMillis();
		for(int i=0;i<20000;i++){
			ByteBuffer b=ByteBuffer.allocate(1000);
		}
		long endtime=System.currentTimeMillis();
		System.out.println("testBufferAllocate:"+(endtime-starttime));
	}

}
