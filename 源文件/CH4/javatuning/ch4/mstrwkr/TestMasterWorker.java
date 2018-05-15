package javatuning.ch4.mstrwkr;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class TestMasterWorker {

	public class PlusWorker extends Worker{
		public Object handle(Object input){
			Integer i=(Integer)input;
			return i*i*i;
		}
	}
	
	@Test
	public void testMasterWorker() {
		Master m=new Master(new PlusWorker(),5);
		for(int i=0;i<100;i++)
			m.submit(i);
		m.execute();
		int re=0;
		Map<String,Object> resultMap=m.getResultMap();
		while(resultMap.size()>0 || !m.isComplete()){
			Set<String> keys=resultMap.keySet();
			String key=null;
			for(String k:keys){
				key=k;
				break;
			}
			Integer i=null;
			if(key!=null)
				i=(Integer)resultMap.get(key);
			if(i!=null)
				re+=i;
			if(key!=null)
				resultMap.remove(key);
		}
		
		System.out.println("testMasterWorker:"+re);
	}
	
	@Test
	public void testPlus(){
		int re=0;
		for(int i=0;i<100;i++){
			re+=i*i*i;
		}
		System.out.println("testPlus:"+re);
	}

}
