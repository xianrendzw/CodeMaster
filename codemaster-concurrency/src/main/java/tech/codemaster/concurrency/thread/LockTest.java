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

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            increase();
        }
    }

    private void increase() {
        synchronized (LockTest.class) {
            int value = item.getValue();
            value++;
            item.setValue(value);
        }
    }
}
