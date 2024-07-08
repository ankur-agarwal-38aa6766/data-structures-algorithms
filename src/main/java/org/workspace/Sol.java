package org.workspace;

import java.util.concurrent.atomic.AtomicInteger;

public class Sol {
    private static int maxNumber;
    private static int numThreads;
    private static AtomicInteger count = new AtomicInteger(0);

    Runnable customThread = () -> {
        synchronized (Sol.class) {
            while (count.get() < maxNumber) {
                if (Thread.currentThread().getName().equals("thread-" + (count.get() % numThreads))) {
                    System.out.println(Thread.currentThread().getName() + " " + count.getAndIncrement());
                    notifyAll();
                }else
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    };

    public static void main(String[] args) {

        numThreads = 3;
        maxNumber = 50;
        Sol obj = new Sol();

        Thread thread1 = new Thread(obj.customThread);
        thread1.setName("thread-1");

        Thread thread2 = new Thread(obj.customThread);
        thread2.setName("thread-2");

        Thread thread3 = new Thread(obj.customThread);
        thread3.setName("thread-0");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
