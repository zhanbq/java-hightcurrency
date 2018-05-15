package javatuning.ch3.collectionvisittuning;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

public class TestCollectionVisistTuning extends Vector{
	static List collection=new Vector();
	static{
		collection.add("north65");
		collection.add("west20");
		collection.add("east30");
		collection.add("south40");
		collection.add("west33");
		collection.add("south20");
		collection.add("north10");
		collection.add("east9");
	
	}
	public TestCollectionVisistTuning(){
		this.add("north65");
		this.add("west20");
		this.add("east30");
		this.add("south40");
		this.add("west33");
		this.add("south20");
		this.add("north10");
		this.add("east9");
	}
	@Test
	public void testCount() {
		long starttime=System.nanoTime();
	    int count = 0;
	    for(int i = 0; i < collection.size(); i++)
	    {
	      if(    ( ((String) collection.get(i)).indexOf("north") != -1 )
	           || ( ((String) collection.get(i)).indexOf("west") != -1 )
	           || ( ((String) collection.get(i)).indexOf("south") != -1 ) )
	        count++;
	    }
	    long endtime=System.nanoTime();
	    System.out.println(endtime-starttime);
	}
	
	@Test
	public void testCount1() {
	    long starttime=System.nanoTime();
	    int count = 0;
	    int colsize= collection.size();
	    for(int i = 0; i < colsize; i++)
	    {
	      if(    ( ((String) collection.get(i)).indexOf("north") != -1 )
	           || ( ((String) collection.get(i)).indexOf("west") != -1 )
	           || ( ((String) collection.get(i)).indexOf("south") != -1 ) )
	        count++;
	    }
	    long endtime=System.nanoTime();
	    System.out.println(endtime-starttime);
	}
	
	@Test
	public void testCount2() {
		long starttime=System.nanoTime();
	    int count = 0;
	    String s=null;
	    int colsize= collection.size();
	    for(int i = 0; i < colsize; i++)
	    {
	      if(    ( (s = (String) collection.get(i)).indexOf("north") != -1 )
	           || (s.indexOf("west") != -1 )
	           || (s.indexOf("south") != -1 ))
	        count++;
	    }
	    long endtime=System.nanoTime();
	    System.out.println(endtime-starttime);
	}
	
	@Test
	public void testCount2_5() {

		
		long starttime=System.nanoTime();
	    int count = 0;
	    String s=null;
	    int colsize= this.elementCount;
	    for(int i = 0; i < colsize; i++)
	    {
	      if(    ( (s = (String)this.get(i)).indexOf("north") != -1 )
	           || (s.indexOf("west") != -1 )
	           || (s.indexOf("south") != -1 ))
	        count++;
	    }
	    long endtime=System.nanoTime();
	    System.out.println(endtime-starttime);
	}
	
	@Test
	public void testCount3() {
		
		long starttime=System.nanoTime();
	    int count = 0;
	    String s=null;
	    int colsize= this.elementCount;
	    for(int i = 0; i < colsize; i++)
	    {
	      if(    ( (s = (String) elementData[i]).indexOf("north") != -1 )
	           || (s.indexOf("west") != -1 )
	           || (s.indexOf("south") != -1 ))
	        count++;
	    }
	    long endtime=System.nanoTime();
	    System.out.println(endtime-starttime);
	}

}
