package tech.codemaster.concurrency.thread;

/**
 * Created by tomdeng on 16/11/17.
 */
public class LockTest implements Runnable {
    private static final LockItem item = new LockItem(0);

    public static void main(String[] args) throws InterruptedException {
        LockTest test1 = new LockTest();
        LockTest test2 = new LockTest();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(item.getValue());
    }

    private static synchronized void increase3() {
        int value = item.getValue();
        value++;
        item.setValue(value);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            increase1();
        }
    }

    private void increase1() {
        synchronized (this) {
            int value = item.getValue();
            value++;
            item.setValue(value);
        }
    }

    private void increase2() {
        synchronized (item) {
            int value = item.getValue();
            value++;
            item.setValue(value);
        }
    }

    private void increase4() {
        synchronized (LockTest.class) {
            int value = item.getValue();
            value++;
            item.setValue(value);
        }
    }
}
