package javatuning.ch3.tech;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStaticMethod {

	public static void staticMethod(){
	}
	public  void instanceMethod(){
	}
	
	@Test
	public void test() {
		int CIRCLE=100000000;
		long start=System.currentTimeMillis();
		for(int i=0;i<CIRCLE;i++){
			staticMethod();
		}
		System.out.println("staticMethod:"+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		for(int i=0;i<CIRCLE;i++){
			instanceMethod();
		}
		System.out.println("instanceMethod:"+(System.currentTimeMillis()-start));
	}
}
