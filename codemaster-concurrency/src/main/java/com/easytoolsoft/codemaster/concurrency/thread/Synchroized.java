package com.easytoolsoft.codemaster.concurrency.thread;

/**
 * Created by tomdeng on 16/10/14.
 */
public class Synchroized {
    public static void main(String[] args) {
//        Task1 task1 = new Task1();
//        Thread task1t1 = new Thread(() -> {
//            task1.m1();
//        }, "A");
//        Thread task1t2 = new Thread(() -> {
//            task1.m1();
//        }, "B");
//        task1t1.start();
//        task1t2.start();

//        Task2 task2 = new Task2();
//        Thread task2t1 = new Thread(() -> task2.m4t1(), "t1");
//        Thread task2t2 = new Thread(() -> task2.m4t2(), "t2");
//        task2t1.start();
//        task2t2.start();

//        Task3 task3 = new Task3();
//        Thread task3t1 = new Thread(() -> task3.m4t1(), "t1");
//        Thread task3t2 = new Thread(() -> task3.m4t2(), "t2");
//        task3t1.start();
//        task3t2.start();
//
//        Task4 task4 = new Task4();
//        Thread task4t1 = new Thread(() -> task4.m4t1(), "t1");
//        Thread task4t2 = new Thread(() -> task4.m4t2(), "t2");
//        task4t1.start();
//        task4t2.start();

        Task5 task5 = new Task5();
        Thread task5t1 = new Thread(() -> task5.m4t1(), "t1");
        Thread task5t2 = new Thread(() -> task5.m4t2(), "t2");
        task5t1.start();
        task5t2.start();
    }
}

class Task1 {
    public void m1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
}

class Task2 {
    public void m4t1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
}

class Task3 {
    public synchronized void m4t1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
}

class Task4 {
    public synchronized void m4t1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public synchronized void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
}

class Task5 {
    private byte[] lock = new byte[0];
    public void m4t1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public void m4t2() {
        synchronized (lock) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}


