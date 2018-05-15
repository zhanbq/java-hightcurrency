package javatuning.ch5.jvmpara;

import java.util.Vector;

/**
 * -Xmx10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\m.hprof
 *-Xmx10M -XX:OnOutOfMemoryError=c:\reset.bat
 */
public class DumpMemory {
	public static void main(String args[]) throws InterruptedException{
		Vector v=new Vector();
		while(true){
			v.add(new byte[512]);
		}
	}
}
