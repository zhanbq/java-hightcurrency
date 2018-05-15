package javatuning.ch3.collectionvisittuning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestListGet {
	private static final int CIRCLE1 = 100;
	protected List list;
	
	protected void initList(){
		for(int i=0;i<10000;i++)
			list.add(i);
	}
	
	protected void testGet(String funcname){
		int s=list.size();
		long starttime=System.currentTimeMillis();
		for(int k=0;k<CIRCLE1;k++){
			for(int i=0;i<s;i++)
				list.get(i);
		}
		long endtime=System.currentTimeMillis();
		System.out.println(funcname+": "+(endtime-starttime));
	}
	
	@Test
	public void testArrayList() {
		list=new ArrayList();
		initList();
		testGet("testArrayList");
	}

	@Test
	public void testLinkedList() {
		list=new LinkedList();
		initList();
		testGet("testLinkedList");
	}
}
