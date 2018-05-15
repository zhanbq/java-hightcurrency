package javatuning.ch5.tuning;

import java.util.Vector;

/**
 * -Xms10M -Xmx40M -XX:MinHeapFreeRatio=40 -XX:MaxHeapFreeRatio=50
 * 
 * -Xms40M -Xmx40M -XX:MinHeapFreeRatio=40 -XX:MaxHeapFreeRatio=50
 * @author Administrator
 * 
 */

public class HeapSize {
	public static void main(String args[]) throws InterruptedException {
		Vector v = new Vector();
		while (true) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 10)
				v = new Vector();
			Thread.sleep(1);
		}
	}
}
