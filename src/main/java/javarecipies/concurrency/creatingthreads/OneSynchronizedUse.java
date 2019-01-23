package javarecipies.concurrency.creatingthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class OneSynchronizedUse {

     static Object lock = new Object();
     static Lock reentrantLock = new ReentrantLock();
    static class Counter {
        private int count ;

        public  void inc() {
            count++;
        }

        public synchronized void inc1() {
            count++;
        }

        public  void inc2() {
            synchronized (lock) {
                count++;
                lock.notifyAll();
            }
        }

        public synchronized void inc3() {
            reentrantLock.lock();
            count++;
            reentrantLock.unlock();
        }

        public int getCount() {
            return count;
        }
    }

    public static void process() {

        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 99; i++) c.inc();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 98; i++) c.inc();
            }
        });


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 97; i++) c.inc();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(5);
        Counter summation = new Counter();

        IntStream.range(0, 963)
                .forEach(count -> service.submit(summation::inc));
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value : " + summation.getCount());
    }

    public static void main(String[] args) {

        process();

    }
}
