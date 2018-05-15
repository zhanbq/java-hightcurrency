package javatuning.ch3.directbuffer;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 直接内存的读取速度比较快
 * @author Administrator
 *
 */
public class TestBufferRead {

	@Test
	public void testDirectWrite() {
		long starttime=System.currentTimeMillis();
		ByteBuffer b=ByteBuffer.allocateDirect(500);
		for(int i=0;i<100000;i++){
			for(int j=0;j<99;j++)
				b.putInt(j);
			b.flip();
			for(int j=0;j<99;j++)
				b.getInt();
			b.clear();
		}
		long endtime=System.currentTimeMillis();
		System.out.println("testDirectWrite:"+(endtime-starttime));
	}
	
	@Test
	public void testBufferWrite() {
		long starttime=System.currentTimeMillis();
		ByteBuffer b=ByteBuffer.allocate(500);
		for(int i=0;i<100000;i++){
			for(int j=0;j<99;j++)
				b.putInt(j);
			b.flip();
			for(int j=0;j<99;j++)
				b.getInt();
			b.clear();
		}
		long endtime=System.currentTimeMillis();
		System.out.println("testBufferWrite:"+(endtime-starttime));
	}

	
}
