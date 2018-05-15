package javatuning.ch4.kilim;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.amino.pattern.internal.Doable;
import org.amino.pattern.internal.DynamicWorker;
import org.amino.pattern.internal.MasterWorker;
import org.amino.pattern.internal.MasterWorkerFactory;
import org.amino.pattern.internal.WorkQueue;
import org.junit.Test;

public class TestMasterWorker {
	static int CIRCLE=10000;
	static int THREAD_NUM=8000;
	public class Pow3 implements Doable<Integer,Integer>{
		@Override
		public Integer run(Integer input) {
			return input*input*input;
		}
	}
	
	@Test
	public void testStatic() {
		MasterWorker<Integer,Integer> mw=MasterWorkerFactory.newStatic(new Pow3(),THREAD_NUM);
		List<MasterWorker.ResultKey> keyList=new Vector<MasterWorker.ResultKey>();
		long beginTime=System.currentTimeMillis();
		for(int i=0;i<CIRCLE;i++){
			keyList.add(mw.submit(i));
		}
		mw.execute();
		int re=0;
		while(keyList.size()>0){					//不等待全部执行完成，就开始求和
			MasterWorker.ResultKey k=keyList.get(0);
			Integer i=mw.result(k);
			if(i!=null){
				re+=i;
				keyList.remove(0);
			}
		}
		long endtime=System.currentTimeMillis();
		System.out.println("spend time:"+(endtime-beginTime));
		System.out.println(re);
	}
}
