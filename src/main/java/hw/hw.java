package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class hw {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Student> list = new ArrayList<>();
//        list.add(new Student("Alice", 20, 90.0));
//        list.add(new Student("Bob", 19, 80.5));
//        list.add(new Student("Andrew", 23, 92));
//        list.add(new Student("Andy", 18, 35));
//        list.add(new Student("Body", 20, 91.5));
//        list.add(new Student("Alexz", 15, 60));
//        //Use Stream API to find all student'name starting with 'A'
//        List<String> nameStartwithA = list.stream().map(Student::getName).filter(val -> val.startsWith("A")).collect(Collectors.toList());
//
//        System.out.println("The name start with 'A' " + nameStartwithA);
//        //•	use stream api to get the sum of all the students score
//        double sumOfALLStudent = list.stream().mapToDouble(Student::getScore).sum();
//        System.out.println("Sum of the all Student " + sumOfALLStudent);
//        //•	use stream api to find all the students whose sore >= 60
//        List<Student> students = list.stream().filter(student -> student.getScore() >= 60).collect(Collectors.toList());
//        students.forEach(student -> {
//            System.out.println("Those student score is greater then 60 " + student.getName());
//        });
//
//        //•	use stream api to retrieve all students name
//        List<String> allStuentName = list.stream().map(Student::getName).collect(Collectors.toList());
//
//        System.out.println(allStuentName);
//
//        //•	use stream api to count the frequency of each age
//        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Student :: getAge, Collectors.counting()));
//        map.forEach((age, count) -> {
//            System.out.println("Age " + age + " Count " + count);
//        });
//        ExecutorService threadPool = new ThreadPoolExecutor(2, 5 ,2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));
//        for(int i = 0; i < 10; i++) {
//            threadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + "create by threadPool");
//            });
//        }
//        threadPool.shutdown();

        System.out.println("Main Thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int num = 1;
            return num + 10;
        }).thenApply(val -> val * 4 ).thenAcceptAsync(result -> {
            System.out.println("Final result: "+ result);
        }).handle((val, ex) -> {
            System.out.println("Get info the handle method");
            if(ex == null) {
                System.out.println("task done");
                return null;
            } else {
                System.out.println("Exception throw" + ex.getMessage());
                return 0;
            }
        });
        future.get();

    }
}

//class Student {
//    private String name;
//    private int age;
//    private double score;
//
//    public Student(String name, int age, double score) {
//        this.name = name;
//        this.age = age;
//        this.score = score;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getScore() {
//        return this.score;
//    }
//    public int getAge() {
//        return this.age;
//    }
//}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Thread is created by extending thread class");
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Thread is created by implementing thread interface");
    }
}
class CallableThread implements Callable {

    @Override
    public Object call() throws Exception {

        return 123;
    }
}
