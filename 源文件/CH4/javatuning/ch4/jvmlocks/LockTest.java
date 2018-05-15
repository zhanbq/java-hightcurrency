package javatuning.ch4.jvmlocks;

import org.junit.Test;

/**
 * -server -XX:-DoEscapeAnalysis -XX:-EliminateLocks 
 */
public class LockTest {
	private static final int CIRCLE = 20000000; 

	public static void main(String args[]) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			craeteStringBuffer("Java", "Performance");
		}
		long bufferCost = System.currentTimeMillis() - start;
		System.out.println("craeteStringBuffer: " + bufferCost + " ms");
	}

	public static String craeteStringBuffer(String s1, String s2) {
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		return sb.toString();
	}
}