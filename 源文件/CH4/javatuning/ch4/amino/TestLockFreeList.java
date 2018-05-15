package javatuning.ch4.amino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.amino.ds.lockfree.LockFreeList;
import org.amino.ds.lockfree.LockFreeVector;
import org.junit.Test;

public class TestLockFreeList {
	private static final int MAX_THREADS = 2000;
	private static final int TASK_COUNT = 4000;
	List list;
	
	public class AccessListThread implements Runnable{
		protected String name;
		java.util.Random rand=new java.util.Random();
		public AccessListThread(){
		}
		public AccessListThread(String name){
			this.name=name;
		}
		@Override
		public void run() {
			try {
				for(int i=0;i<1000;i++)
					handleList(rand.nextInt(1000));
				Thread.sleep(rand.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public class CounterPoolExecutor extends ThreadPoolExecutor{
		private AtomicInteger count =new AtomicInteger(0);
		public long startTime=0;
		public String funcname="";
		public CounterPoolExecutor(int corePoolSize, int maximumPoolSize,
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}
		
		protected void afterExecute(Runnable r, Throwable t) { 
			int l=count.addAndGet(1);
			if(l==TASK_COUNT){
				System.out.println(funcname+" spend time:"+(System.currentTimeMillis()-startTime));
			}
		}
	}
	
	public Object handleList(int index){
		list.add(index);
		list.remove(index%list.size());
		return null;
	}
	
	public void initLinkedList(){
		List l=new ArrayList();
		for(int i=0;i<1000;i++)
			l.add(i);
		list=Collections.synchronizedList(new LinkedList(l));
	}

	public void initVector(){
		List l=new ArrayList();
		for(int i=0;i<1000;i++)
			l.add(i);
		list=new Vector(l);
	}
	
	public void initFreeLockList(){
		List l=new ArrayList();
		for(int i=0;i<1000;i++)
			l.add(i);
		list=new LockFreeList(l);
	}
	
	public void initFreeLockVector(){
		list=new LockFreeVector();
		for(int i=0;i<1000;i++)
			list.add(i);
	}
	
	//@Test
	public void testFreeLockList() throws InterruptedException {
		initFreeLockList();
		CounterPoolExecutor exe=new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

		long starttime=System.currentTimeMillis();
		exe.startTime=starttime;
		exe.funcname="testFreeLockList";
		Runnable t=new AccessListThread();
		for(int i=0;i<TASK_COUNT;i++)
			exe.submit(t);
		
		Thread.sleep(10000);
	}

	//@Test
	public void testLinkedList() throws InterruptedException {
		initLinkedList();
		CounterPoolExecutor exe=new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

		long starttime=System.currentTimeMillis();
		exe.startTime=starttime;
		exe.funcname="testLinkedList";
		Runnable t=new AccessListThread();
		for(int i=0;i<TASK_COUNT;i++)
			exe.submit(t);
		
		Thread.sleep(10000);
	}
	
	//@Test
	public void testVector() throws InterruptedException {
		initVector();
		CounterPoolExecutor exe=new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

		long starttime=System.currentTimeMillis();
		exe.startTime=starttime;
		exe.funcname="testVector";
		Runnable t=new AccessListThread();
		for(int i=0;i<TASK_COUNT;i++)
			exe.submit(t);
		
		Thread.sleep(10000);
	}
	
	@Test
	public void testFreeLockVector() throws InterruptedException {
		initFreeLockVector();
		CounterPoolExecutor exe=new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

		long starttime=System.currentTimeMillis();
		exe.startTime=starttime;
		exe.funcname="testFreeLockVector";
		Runnable t=new AccessListThread();
		for(int i=0;i<TASK_COUNT;i++)
			exe.submit(t);
		
		Thread.sleep(10000);
	}
}
