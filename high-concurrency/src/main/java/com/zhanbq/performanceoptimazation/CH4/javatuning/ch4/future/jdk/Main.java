package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	//����FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //ִ��FutureTask���൱�������е� client.request("a") ��������
        //�����￪���߳̽���RealData��call()ִ��
        executor.submit(future);
        System.out.println("�������");
        try {
        //������Ȼ��������������ݲ���������ʹ��sleep��������ҵ���߼��Ĵ���
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        //�൱�������е�data.getContent()��ȡ��call()�����ķ���ֵ
        //�����ʱcall()����û��ִ����ɣ�����Ȼ��ȴ�
        System.out.println("���� = " + future.get());
    }
}
