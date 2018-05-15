package javatuning.ch3.directbuffer;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * ÄÚ´æ·ÖÅä
 * -XX:MaxDirectMemorySize=10M -Xmx10m -Xloggc:c:\gc.log -XX:+PrintGC
 * @author Administrator
 *
 */
public class TestBufferBig {

	@Test
	public void testDirectWrite() {
		long starttime=System.currentTimeMillis();
		ByteBuffer b=ByteBuffer.allocateDirect(3*1024*1024);
		b=null;
		//System.gc();
		b=ByteBuffer.allocateDirect(3*1024*1024);
		ByteBuffer b1=ByteBuffer.allocate(4*1024*1024);
	}
	
	@Test
	public void testBufferWrite() {	
		long starttime=System.currentTimeMillis();
		ByteBuffer b=ByteBuffer.allocate(1*1024*1024);

	}

	
}
