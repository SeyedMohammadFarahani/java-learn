package F_Other_Files;

public class MultiThread {

    enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED;
    }
    public static void main(String[] args) throws InterruptedException {
        /* number 1 */
        MyThread t1 = new MyThread();
        t1.start();
        /* number 2 */
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        /* Todo Thread Methods */
        //get current method
        Thread t = Thread.currentThread();

        //sleep current method
        Thread.sleep(1000, 500);

        //join
        Thread virusScan = new MyThread();
        virusScan.start();
        System.out.println("Prepare email");
        virusScan.join();
        System.out.println("Send email email");

        //set priority from 1 to 10
        MyThread th = new MyThread();
        th.setPriority(Thread.MAX_PRIORITY);
        th.start();

        //set Daemon
        MyThread daemon = new MyThread();
        daemon.setDaemon(true);
        daemon.start();

        //getState

        Thread state = new MyThread();
        state.start();
        state.getState();


    }

    /* TODO Wait & Notify */
    synchronized void f() {
        try {
            wait(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            this.notify();
        }

        synchronized (this) {
            this.notifyAll();
        }

    }

}

/**
 * 2 way to create Thread
 */

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello");
        System.out.println("Bye");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello");
        System.out.println("Bye");
    }
}

/**
 * critical section define with "synchronized"
 */
class BankAccount {
    private float balance;

    /*number 1*/
    public synchronized void deposit(float amount) {
        balance += amount;
    }

    public synchronized void withdraw(float amount) {
        balance -= amount;
    }

    /*number 2*/
    void g1() {
        synchronized (this) {
            System.out.println();
        }
    }

    synchronized void g2() {
        System.out.println();
    }

}
