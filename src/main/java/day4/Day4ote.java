package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Day4ote {
  /*
  1.Stream Api
    java.util.stream package
        intermediate operation  return a stream
            filter, map, distinct, limit, flatmap
        terminal operation  return a normal datatype not a stream
            collect, forEach, reduce,min, max...
        all variable create by stream is immutable dataype, so it is thread safe

        List<Integer> list =new ArrayList<>(Arrays.asList(1,2,3,5,8,4,6,7));
        List<Integer> res = list.stream().map(e -> e+ 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(res);

        Character[] array = new Character[] {'a', 'c', 'd','z','r', 'c'};
        Map<Character, Integer> map =  Arrays.stream(array).collect(Collectors.toMap(c -> c, c->1,(a, b) -> a + b));
        System.out.println(map);

    2. Multi-threading
        Thread vs process
            Thread: independent stack, PC register,
            Process: independent memory space, stack, heap, os resources
        thread state
            new, runnable, blocked, waiting, timed-waiting, terminated
         how to create a thread
            extending the thread
            implements Runnable interface
            implement callable interface
            threadpool

            Runnable vs Callable
             runnable override the run method no return, no exception
             callable override the call method, need exception

          class MyThread extends Thread {
    @Override
        public void run() {
        System.out.println(Thread.currentThread().getName() + "thread is created by extending  thread class");
    }
}
class RunnableThread implements Runnable {
    @Override
        public void run() {
        System.out.println(Thread.currentThread().getName() + "thread is created by implementing Runnable interface");
    }
}

class CallableThread implements Callable {
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + "thread is created by implementing Callable interface");
        return 123;
    }
}
        ThreadPool
            ThreadPoolExecutor: corepPoolSize, maximumPoolsize,keepaliveTime,unit, workQueue, treadFactory, handler
            ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 2L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for(int i  = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "thread is created by implementing Runnable interface");
            });
        }
        threadPool.shutdown();

   */

    public static void main(String[] args) {

    }
}
