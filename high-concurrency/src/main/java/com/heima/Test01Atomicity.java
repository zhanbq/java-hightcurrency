package com.heima;

import java.util.ArrayList;

/**
 * 案例演示:5个线程各执行1000次 i++;
 */
public class Test01Atomicity {
    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (Test01Atomicity.class) {
                        number++;
                    }
                }
            }
        };
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t = new Thread(increment);
            t.start();
            ts.add(t);
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println("number = " + number);
    }
}