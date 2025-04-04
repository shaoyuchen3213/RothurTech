package hw;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try{
                lock1.lock();;
                System.out.println("Thread 1: Acquire lokc1");
                Thread.sleep(100);
                System.out.println("Thread1 is waitting for thread2");
                lock2.lock();
                System.out.println("Thread 1: Acquire lock 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                lock1.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println("Thread 2: Acquired lock");
                Thread.sleep(100);
                System.out.println("Thread 2 is waitting for thread 1");
                lock1.lock();
                System.out.println("Thread 1: Acquired lock");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                {
                    if(lock1.isHeldByCurrentThread()) {
                        lock1.unlock();
                    }
                    lock2.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
