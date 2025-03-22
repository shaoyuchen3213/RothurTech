package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class hw3 {


    public static void main(String[] args){
        /*
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        //using Lambda expression
        names.forEach(name -> System.out.println(name));

        //using method reference
        names.forEach(System.out::println);

        //try with resource
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader br= null;
        try {
            br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();
            System.out.println(line);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try{
                    br.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


        //Runtime exception example
        int numerator = 10;
        int denominator = 0; // this will cause an ArithmeticException


            int result = numerator / denominator;
            System.out.println();
        */

        /*class Box<T> {
            private T value;
            public void set(T value) {
                this.value = value;
            }
            public T get() {
                return this.value;
            }
        }
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());

        Box<String> inBox2 = new Box<>();
        inBox2.set("Bob");
        System.out.println(inBox2.get());


        Integer[] number = {1,2,3};
        String[] words = {"A", "B", "C"};

        Utils.printArray(number);
        Utils.printArray(words);
        */

        Predicate<String> isLongName = name -> name.length() > 5;
        System.out.println(isLongName.test("Alice"));
        System.out.println(isLongName.test("Jonathan"));

        Supplier<String> nameSupplier = () -> "Generated Name";

        System.out.println(nameSupplier.get());  // "Generated Name"

        Consumer<String> greeter = name -> System.out.println("Hello" + name);
        greeter.accept("Bob");

        Function<String, Integer> listMapping = str -> str.length();
        System.out.println(listMapping.apply("Hello"));
    }
    public class Utils {
        public static <T> void printArray(T[] array) {
            for(T item: array) {
                System.out.println(item + " ");
            }
            System.out.println();
        }
    }
}
