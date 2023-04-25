package F_Other_Files;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, ExecutionException {

        /* Todo Non Thread Safe Vs. Thread Safe */
        /**
         * ArrayList & Vector
         * HashMap & ConcurrentHashMap
         * StringBuilder StringBuffer
         * Queue & BlockingQueue
         * */

        StringBuffer buffer = new StringBuffer("12");
        buffer.append("345");
        String s = buffer.toString();
        System.out.println(s);

        Queue arrayQueue = new ArrayBlockingQueue(10);
        Queue linkedQueue = new LinkedBlockingQueue();

        /* Todo Semaphore */
        List list = new ArrayList<String>();
        Semaphore semaphore = new Semaphore(0);

        synchronized (list) {
            String obj = "temp";
            list.add(obj);
        }
        semaphore.release();

        semaphore.acquire();
        synchronized (list) {
            String obj = list.remove(0).toString();
        }

        /* Todo CountDownLatch */
        CountDownLatch latch = new CountDownLatch(2);
        //Thread 1
        latch.await();
        System.out.println("Finished!");
        //Thread 2
        latch.countDown();
        //Thread 1
        latch.countDown();

        /* Todo Exchanger */
        Exchanger<String> e = new Exchanger<>();
        //Thread 1
        e.exchange("x=2");
        //Thread 2
        e.exchange("y=3");

        /* Todo CyclicBarrier */
        CyclicBarrier barrier = new CyclicBarrier(3);
        barrier.await();

        /* Todo Atomic Classes */
        /**
         * AtomicBoolean, AtomicInteger, AtomicIntegerArray, AtomicLong, AtomicReferenceArray, ...
         * */

        /* Todo Lock */
        Lock l = new ReentrantLock();
        l.lock();
        try {
            // critical section
        } finally {
            l.unlock();
        }

        /* Todo ReadWriteLock */
        List<Double> linkedList = new LinkedList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        /* Todo Executors */
        // newSingleThreadExecutor, newFixedThreadPool, newCachedThreadPool
        Executor ex1 = Executors.newSingleThreadExecutor();
        Executor ex2 = Executors.newFixedThreadPool(2);
        Executor ex3 = Executors.newCachedThreadPool();
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 4; i++)
                    System.out.println(Thread.currentThread().getId() + ":" + i);
            }
        };
        for (int i = 0; i < 3; i++) {
            ex1.execute(runnable);
            ex2.execute(runnable);
            ex3.execute(runnable);
        }

        /* Todo Interface Callable */
        /**
         * instead of Runnable
         * call() instead of run()
         * return value
         * */

        /* Todo Future & Executor.submit */
        ExecutorService pool = Executors.newCachedThreadPool();
        Set<Future<Integer>> set = new HashSet<>();
        String[] words = {"Ali", "Taghi", "Naghi"};
        for (String word : words) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set)
            sum += future.get();
        //return 13
        System.out.println("The sum of lengths is " + sum);


    }
}

class Reader extends Thread {
    public void run(ReentrantReadWriteLock lock, LinkedList list) {
        lock.readLock().lock();
        System.out.println(list.get(0));
        lock.readLock().unlock();
    }
}

class Writer extends Thread {
    public void run(ReentrantReadWriteLock lock, LinkedList list) {
        lock.writeLock().lock();
        list.add(0, Math.random());
        lock.writeLock().unlock();
    }
}

class WordLengthCallable implements Callable<Integer> {
    private String word;

    public WordLengthCallable(String word) {
        this.word = word;
    }

    public Integer call() {
        return word.length();
    }
}


