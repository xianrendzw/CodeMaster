package com.easytoolsoft.codemaster.concurrency.thread;

/**
 * Synchroized 关键字
 * 1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 * 2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 * 3. 修饰一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 * 4. 修饰一个类，其作用的范围是synchronized后面括号括起来的部分，作用的对象是这个类的所有对象
 * 5. synchronized关键字不能继承,虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
 * 因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，而在子类中覆盖了这个方法，
 * 在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个方法中加上synchronized关键字才可以。
 * 当然，还可以在子类方法中调用父类中相应的方法，这样虽然子类中的方法不是同步的，但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了。
 * 6. 在定义接口方法时不能使用synchronized关键字。
 * 7. 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。
 * 总结：
 * <p>
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。</p>
 * <p>
 * 对synchronized(this)的一些理解
 * 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线
 * <p>
 * 程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized
 * <p>
 * (this)同步代码块。
 * 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)
 * <p>
 * 同步代码块的访问将被阻塞。
 * 四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个
 * <p>
 * object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
 * 五、以上规则对其它对象锁同样适用
 * synchronized static method{}防止多个线程同时访问这个类中的synchronized static 方法。它可以对类的所有对象实例起作用
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


