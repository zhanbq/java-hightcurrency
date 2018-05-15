package javatuning.ch5.memory;

/**
 * -Xss1M -Xmx300M -Xms300M
 * @author Administrator
 *
 */
public class TestXss {
	public static class MyThread extends Thread{
		@Override
		public void run(){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		int i=0;
		try{
			for( i=0;i<10000;i++){
				new MyThread().start();
			}
		}catch(OutOfMemoryError e){
			System.out.println("count thread is "+i);
			e.printStackTrace();
		}
	}
}
