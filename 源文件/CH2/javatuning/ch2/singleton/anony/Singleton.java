package javatuning.ch2.singleton.anony;

public abstract class Singleton {
	private Singleton(){
		//创建单例的过程可能会比较慢
	}

	private static Singleton instance = new Singleton(){};
	public static Singleton getInstance() {
		return instance;
	} 
}