package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.gs.future;

import java.util.ArrayList;
import java.util.List;

import com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.future.pattern.FutureData;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    private List<Request> myRequest=new ArrayList<Request>();
    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    public void run() {
    	//���������
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i+" Thread_Name:"+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            request.setResponse(new FutureData());
            requestQueue.addRequest(request);
            myRequest.add(request);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        
        //ȡ�÷���˵ķ���ֵ
        for(Request r:myRequest){
            System.out.println("ClientThread Name is:"+
            		Thread.currentThread().getName()+
            		" Reponse is:"+
            		r.getResponse().getResult());
        }
    }
}
