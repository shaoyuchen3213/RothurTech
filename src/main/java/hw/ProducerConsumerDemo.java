package hw;



import java.util.*;

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

    public void put() throws InterruptedException {
        synchronized (queue) {
            while(queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + "wait, queue is full");
                queue.wait();
            }
            int tempVal = myRandom.nextInt(100);
            queue.offer(tempVal);
            System.out.println(Thread.currentThread().getName() + "put" + tempVal);
            queue.notifyAll();
        }
    }
    public void take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + "wait producer to produce product");
                queue.wait();
            }
            int tempVal = queue.poll();
            System.out.println(Thread.currentThread().getName() + "take" + tempVal);
            queue.notifyAll();
            ;
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
        try {
            pc.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        try {
            pc.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
