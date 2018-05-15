package javatuning.ch4.future.pattern;

public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        // RealData的构建很慢
        new Thread() {                                      
            public void run() {                             
                RealData realdata = new RealData(queryStr);
                future.setRealData(realdata);
            }                                               
        }.start();
        return future;
    }
}
