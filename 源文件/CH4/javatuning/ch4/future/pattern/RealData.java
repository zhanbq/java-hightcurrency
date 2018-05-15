package javatuning.ch4.future.pattern;

public class RealData implements Data {
    protected final String result;
    public RealData(String para) {
    	//RealData的构造可能很慢，需要用户等待很久
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
