package com.easytoolsoft.codemaster.concurrency.thread;

/**
 * Created by tomdeng on 16/11/17.
 */
public class WaitNotifyTest {
    public static void main(String... args) throws InterruptedException {
        final byte[] lock = new byte[0];

        final Thread master = new Thread("master") {
            @Override
            public void run() {
                System.out.println("master is ready!");
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                }
                synchronized (lock) {
                    lock.notify();
                    System.out.println("master is notify, but not exit synchronized");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("master is exit synchronized");
            }
        };

        final Thread slaver = new Thread("slaver") {
            @Override
            public void run() {
                System.out.println("slaver is ready!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (lock) {
                    try {
                        System.out.println("slaver is waiting!");
                        lock.wait();
                        System.out.println("slaver is awake!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        master.start();
        slaver.start();
    }
}
