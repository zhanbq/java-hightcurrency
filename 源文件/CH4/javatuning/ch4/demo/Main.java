package javatuning.ch4.demo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				//do sth. 
			}
		}).start();

	}

}
