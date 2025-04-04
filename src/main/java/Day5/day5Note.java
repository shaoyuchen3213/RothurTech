package Day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class day5Note {
    /*
    CompltableFuture: Future and CompletationState
        sync and async:

        client -> browser -> server  client need to wait the result sync
        client -> broswer -> server  client get result immediated  async

        without any return
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try{
                System.out.println("child thread starts working");
                Thread.sleep(5000);
                System.out.println("Child thread end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.get();
        System.out.println("Main thread end");

        with return
             System.out.print("Main Thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Start adding 50 to number");
            num += 50;
            return num;
        }).thenApply(val -> num * 2).thenApplyAsync(val -> val + 100);
        System.out.println("task result" + future.get());

        System.out.println("Main thread end");

        exception
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Start adding 50 to number");
            int resul = 1 / 0;
            num += 50;
            return num;
        }).handle((val, ex) -> {
            System.out.println("get info the handle method");
            if (ex == null) {
                System.out.println("task done");
                return null;
            } else {
                System.out.println("exception thrown" + ex.getMessage());
                return 400;
            }
        });,t
        Lock
            parallel vs concurrent

            Lock:
                synchronize code block / method / static method/ class

                Lock Interface: ReentrantLock: lock(), unlock(); trylock()
                ReadWriteLock interface: ReentrantReadWriteLock
                    Lock readLock();
                    Lock writeLock();
               there is fair lock and unfair lock
          Dead Lock:
            two or more thread are waiting for each other
            how to prevent dead lock
                avoid nested locks
                avoid unnecessary lock
                    stack, vector, hashtable

     */
    private static Integer num = 100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }
}

