package com.zhanbq.performanceoptimazation.CH2.javatuning.ch2.singleton;

public class Singleton {
	private Singleton() {
		//���������Ĺ��̿��ܻ�Ƚ���
		System.out.println("Singleton is create");
	}

	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}

	public static void createString(){
		System.out.println("createString in Singleton");
	}
}