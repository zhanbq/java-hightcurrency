package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.mstrwkr;

import java.util.Map;
import java.util.Queue;


public class Worker implements Runnable{
	//������У�����ȡ��������
	protected Queue<Object> workQueue;
	//������������
	protected Map<String,Object> resultMap;
	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	//����������߼�����������ʵ�־����߼�
	public Object handle(Object input){
		return input;
	}
	
	@Override
	public void run() {
		while (true) {
			 //��ȡ������
			 Object input = workQueue.poll();
			 if (input == null) break;
			 //����������
			 Object re=handle(input);
			 //��������д������
			 resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}
}
