package javatuning.ch4.locks;

public class LockDemo {
	
	protected void mutextMethod(){
		
	}
	
	protected void othercode1(){
		
	}
	
	protected void othercode2(){
		
	}
	
	public synchronized void syncMethod(){
		othercode1();
		mutextMethod();
		othercode2();
	}
	
	public void syncMethod2(){
		othercode1();
		synchronized(this){
			mutextMethod();
		}
		othercode2();
	}
	
}
