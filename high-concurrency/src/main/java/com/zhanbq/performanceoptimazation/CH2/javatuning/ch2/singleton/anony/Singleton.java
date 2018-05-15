package com.zhanbq.performanceoptimazation.CH2.javatuning.ch2.singleton.anony;

public abstract class Singleton {
	private Singleton(){
		//���������Ĺ��̿��ܻ�Ƚ���
	}

	private static Singleton instance = new Singleton(){};
	public static Singleton getInstance() {
		return instance;
	} 
}