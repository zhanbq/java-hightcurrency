package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.threadpool.simple;

import java.util.List;
import java.util.Vector;

public class ThreadPool 
{
    private static ThreadPool instance = null;

    //���е��̶߳���
    private List<PThread> idleThreads;
    //���е��߳�����
    private int threadCounter;
    private boolean isShutDown = false;
    
    private ThreadPool() 
    {       
        this.idleThreads = new Vector(5);
        threadCounter = 0;
    }
    
    public int getCreatedThreadsCount() {
        return threadCounter;
    }
    
    //ȡ���̳߳ص�ʵ��
    public synchronized static ThreadPool getInstance() {
        if (instance == null)
            instance = new ThreadPool();
        return instance;
    }
   
    //���̷߳������
    protected synchronized void repool(PThread repoolingThread)
    {
        if (!isShutDown) 
        {
            idleThreads.add(repoolingThread);
        }
        else 
        {
            repoolingThread.shutDown();//�ر��߳�
        }
    }
        
    //ֹͣ���������߳�
    public synchronized void shutdown()
    {
       isShutDown = true;
       for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++)
       {
             PThread idleThread = (PThread) idleThreads.get(threadIndex);
             idleThread.shutDown();
       }
    }
    
    //ִ������
    public synchronized void start(Runnable target)
    {
        PThread thread = null; 
        //����п����̣߳���ֱ��ʹ��
        if (idleThreads.size() > 0) 
        {
            int lastIndex = idleThreads.size() - 1;
            thread = (PThread) idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            //����ִ���������
            thread.setTarget(target);
        }
        //û�п����̣߳��򴴽����߳�
        else 
        { 
            threadCounter++;
            // �������̣߳�
            thread = new PThread(target, "PThread #" + threadCounter, this);
            //��������߳�
            thread.start();
        }
    }
}