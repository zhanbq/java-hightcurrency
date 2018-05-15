package javatuning.ch4.future.pattern;

public class FutureData implements Data {
    protected RealData realdata = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realdata) {
        if (isReady) {                        
            return;     
        }
        this.realdata = realdata;
        isReady = true;
        notifyAll();
    }
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realdata.result;
    }
}
