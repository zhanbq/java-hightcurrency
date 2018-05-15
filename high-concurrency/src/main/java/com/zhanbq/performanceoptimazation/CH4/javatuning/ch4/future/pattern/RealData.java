package com.zhanbq.performanceoptimazation.CH4.javatuning.ch4.future.pattern;

public class RealData implements Data {
    protected final String result;
    public RealData(String para) {
    	//RealData�Ĺ�����ܺ�������Ҫ�û��ȴ��ܾ�
    	StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 10; i++) {
        	sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        result=sb.toString();
    }
    public String getResult() {
        return result;
    }
}
