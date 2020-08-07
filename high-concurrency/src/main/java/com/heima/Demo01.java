import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        Runnable mr = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
            }
        };
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(mr);
            t.start();
            ts.add(t);
        }
        for (Thread t : ts) {
            // join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
            // 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
            t.join();
        }
        System.out.println("number = " + atomicInteger.get());
    }
}