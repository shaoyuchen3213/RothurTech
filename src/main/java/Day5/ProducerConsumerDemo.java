package Day5;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    producers -> [queue size = 5] <- consumers
 */

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        ProducerConsumerModel sharedObject = new ProducerConsumerModel();
        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();
        for(int i = 0; i <=5; i++) {
            producers.add(new Producer("producer" + i, sharedObject));
        }
        for(int i = 0; i <=5; i++) {
            consumers.add(new Consumer("consumer" + i, sharedObject));
        }
        for(Producer p : producers) p.start();
        for(Consumer c : consumers) c.start();
    }
}
class ProducerConsumerModel {
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 3;

    private Random myRandom = new Random();

    Lock lock = new ReentrantLock();
    Condition queueNotFull = lock.newCondition();
    Condition queueNotEmpty = lock.newCondition();
    public void put() {
        lock.lock();
        try {
            while(queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + "wait, queue is full");
                queueNotFull.await();
            }
            int tempVal = myRandom.nextInt(100);
            queue.offer(tempVal);
            System.out.println(Thread.currentThread().getName() + "put" + tempVal);
            queueNotEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void take() {
        lock.lock();
        try {
            while(queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + "waitting producer to produce product");
                queueNotEmpty.await();
            }
            int tempval = queue.poll();
            System.out.println(Thread.currentThread().getName() + "take" + tempval);
            queueNotFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
class Producer extends Thread {
    private String name;
    ProducerConsumerModel pc;
    public Producer(String name, ProducerConsumerModel sharedObject) {
        this.name = name;
        this.pc = sharedObject;
    }

    @Override
    public void run() {
        pc.put();
    }
}
class Consumer extends Thread {
    private String name;
    ProducerConsumerModel pc;
    public Consumer(String name, ProducerConsumerModel sharedObject) {
        this.name = name;
        this.pc = sharedObject;
    }

    @Override
    public void run() {
        pc.take();
    }
}