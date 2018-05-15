package javatuning.ch2.singleton;
public class LazySingleton {
		private LazySingleton(){
			//创建单例的过程可能会比较慢
			System.out.println("LazySingleton is create");
		}
		private static LazySingleton instance = null;
		public static synchronized LazySingleton getInstance() {
		if (instance==null)
			instance=new LazySingleton();
		return instance;
	}
}