package com.zhanbq.performanceoptimazation.CH2.javatuning.ch2.singleton.serialization;

public class SerSingleton implements java.io.Serializable{
	String name;
	
	private SerSingleton() {
		//���������Ĺ��̿��ܻ�Ƚ���
		System.out.println("Singleton is create");
		name="SerSingleton";
	}

	private static SerSingleton instance = new SerSingleton();
	public static SerSingleton getInstance() {
		return instance;
	}

	public static void createString(){
		System.out.println("createString in Singleton");
	}
	
	private Object readResolve(){  
        return instance;  
    }  
}