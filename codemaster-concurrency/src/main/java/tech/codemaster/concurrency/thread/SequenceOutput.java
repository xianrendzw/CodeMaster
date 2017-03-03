/*
* Copyright (c) 2016 Tom Deng
* 
* Permission is hereby granted, free of charge, to any person obtaining
* a copy of this software and associated documentation files (the
* "Software"), to deal in the Software without restriction, including
* without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Software, and to
* permit persons to whom the Software is furnished to do so, subject to
* the following conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
* LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
* OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
* WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package tech.codemaster.concurrency.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
public class SequenceOutput {
    static final byte[] lock = new byte[0];
    static AtomicInteger atomicCount = new AtomicInteger(1);
    static int count = 1;

    static long startTime = 0;

    static int[] result = new int[10_000_000];

    public static void main(String... args) {
//        startTime = System.nanoTime();
//        System.out.println(startTime);
//        parallizedExecute();
//        System.out.println((System.nanoTime() - startTime) / 1.0e9);

        new Thread(new Task3(),"1").start();
        new Thread(new Task3(),"2").start();
    }

    private static void parallizedExecute() {
        try {
            List<Future<Void>> futures = Executors
                    .newFixedThreadPool(2)
                    .invokeAll(getCallables());
            if (futures.get(0).isDone() && futures.get(1).isDone()) {
                for (int i = 0; i < 10_000_000; i++) {
                    System.out.println(result[i]);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Callable<Void>> getCallables() {
        List<Callable<Void>> callables = new ArrayList<>(2);
        callables.add(() -> {
            int count = 1;
            while (count <= 10_000_000) {
                result[count - 1] = count;
                count += 2;
            }
            return null;
        });
        callables.add(() -> {
            int count = 2;
            while (count <= 10000000) {
                result[count - 1] = count;
                count += 2;
            }
            return null;
        });
        return callables;
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            while (atomicCount.get() <= 10000000) {
                synchronized (lock) {
                    int tmp = atomicCount.getAndAdd(1);
                    System.out.println("thread" + Thread.currentThread().getId() + ":" + tmp);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println((System.nanoTime() - startTime) / 1.0e9);
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 10) {
                    System.out.println("thread" + Thread.currentThread().getId() + ":" + count++);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println((System.nanoTime() - startTime) / 1.0e9);
        }
    }

    static class Task3 implements Runnable {
        @Override
        public void run() {
            while (atomicCount.get() <= 10) {
                atomicCount.addAndGet(1);
                System.out.println("thread" + Thread.currentThread().getId() + ":" + (atomicCount.get()));
            }
        }
    }
}
