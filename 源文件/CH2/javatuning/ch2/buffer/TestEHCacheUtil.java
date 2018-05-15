package javatuning.ch2.buffer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEHCacheUtil {

	//@Test
	public void test1() throws InterruptedException {
		EHCacheUtil.put("cache1", "key1","value1");
		System.out.println(EHCacheUtil.get("cache1", "key1"));
		for(int i=0;i<7;i++){
			//EHCacheUtil.get("cache1", "key1");
			Thread.sleep(1000);
		}
		System.out.println(EHCacheUtil.get("cache1", "key1"));
	}
	
	@Test
	public void test2() throws InterruptedException {
		for(int i=0;i<200;i++){
			EHCacheUtil.put("cache1", "key"+i,"value"+i);
			System.out.println("i="+i+" key1="+EHCacheUtil.get("cache1", "key1"));
		}
	}
}
