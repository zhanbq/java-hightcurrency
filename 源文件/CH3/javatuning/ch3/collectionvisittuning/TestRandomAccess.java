package javatuning.ch3.collectionvisittuning;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;

import org.junit.Test;

public class TestRandomAccess {
	List list=null;
	
	@Test
	public void testVector(){
		list=new Vector();
		initList();
		testRandomAccess("testVector");
		testIterator();
	}
	
	public void initList(){
		for(int i=0;i<1000;i++)
			list.add(i);
	}
	public void testIterator(){
		long startTime=System.nanoTime();
		for(int k=0;k<10000;k++){
			Object o;
			  Iterator itr = list.iterator();
			  for (int i=0, n=list.size(); i < n; i++)
			  {
			    o = itr.next();
			   //处理元素对象
			  }
		}
		long endTime=System.nanoTime();
		System.out.println(endTime-startTime);
	}
	public void testRandomAccess(String name) {
		long startTime=System.nanoTime();
		for(int k=0;k<10000;k++){
			Object o;
			if (list instanceof RandomAccess)
			{
			  for (int i=0, n=list.size(); i < n; i++)
			  {
			    o = list.get(i);
			    //处理元素对象
			  }
			}
			else
			{
			  Iterator itr = list.iterator();
			  for (int i=0, n=list.size(); i < n; i++)
			  {
			    o = itr.next();
			   //处理元素对象
			  }
			}
		}
		long endTime=System.nanoTime();
		System.out.println(endTime-startTime);
	}

}
