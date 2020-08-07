package com.mooc;

/**
 * 案例演示: 一个线程根据boolean类型的标记flag， while循环，另一个线程改变这个flag变量的值， 另一个线程并不会停止循环.
 */
public class Test01Visibility {
    // 多个线程都会访问的数据，我们称为线程的共享数据
    private static boolean run = true;
    int a = 1;
    int b = a;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (run) { // 增加对象共享数据的打印，println是同步方法
                System.out.println("run = " + run);
            }
        });
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(() -> {
            run = false;
            System.out.println("时间到，线程2设置为false");
        });
        t2.start();
    }
}