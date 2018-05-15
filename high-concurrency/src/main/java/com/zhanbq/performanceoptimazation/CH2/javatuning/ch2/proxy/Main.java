package com.zhanbq.performanceoptimazation.CH2.javatuning.ch2.proxy;

public class Main {
	public static void main(String args[]){
		IDBQuery q=new DBQueryProxy();	//ʹ�ô���
		q.request();					//������ʹ��ʱ�Ŵ�����ʵ����
	}
}
