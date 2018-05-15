package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.gs.future;

import com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.future.pattern.FutureData;
import com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.future.pattern.RealData;


public class ServerThread extends Thread {
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();
            final FutureData future =   (FutureData)request.getResponse();
            //RealData�Ĵ����ȽϺ�ʱ
            RealData realdata = new RealData(request.getName());
            //������ɺ�֪ͨ�ͻ�����
            future.setRealData(realdata);
            System.out.println(Thread.currentThread().getName() + " handles  " + request);
        }
    }
}
