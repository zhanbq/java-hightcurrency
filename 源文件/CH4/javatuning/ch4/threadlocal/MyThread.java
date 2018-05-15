package javatuning.ch4.threadlocal;

import java.util.Date;

public class MyThread implements Runnable{
	public static final ThreadLocal<Date> localvar= new ThreadLocal<Date>();
	private long time;
	public MyThread(long time){
		this.time=time;
	}
	@Override
	public void run() {
		Date d=new Date(time);
		for(int i=0;i<50000;i++){
			localvar.set(d);
			if(localvar.get().getTime()!=time)
				System.out.println("id="+time+" localvar="+localvar.get().getTime());
		}
	}
}
