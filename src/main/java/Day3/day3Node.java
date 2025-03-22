package Day3;

import org.w3c.dom.Node;

public class day3Node {

    /*
    1. Exception
       Checked Exception: complie time exception, we need to handle it
          2 ways to handle it:
            1. try catch block
            2. throws keyword
           ClassNotFoundException, IOException, SQLException
           public static void main(String[] args) {
        try {
            fileReader("abc.txt");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
    public static void fileReader(String path) throws Exception {
        //FileReader fileReader = new FileReader(path);
    }
         Unchecked Exception: runtime exception, we don't need to handle it
           ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException

      mutilple catch block
        try {
                fileReader("abc.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


         try with resources
            AutoCloseable interface, close() method

            try(FileReader fileReader = new FileReader("abc.txt")) {
            } catch (Exception e) {
                e.printStackTrace();
            }

        2. Genertics
            class Node<K,V> {
                K key;
                V value;
                public Node(K key, V value) {
                    this.key = key;
                    this.value = value;
                }
            }

            public static void main(String[] args) {
                int[][] array = new int[][]{{1,2}, {5}, {1,2,3}}
                why 1D array won't work with Genertics because int cannot be inherited from object, and 2d array is inherited from object
                System.out.println(getElement(array);

            public static<E> E getFirstElement(E[] array) {
                return array[0];
            }

          3. Java 8 new features
          Lambda expression
          (argments) -> {body}
             Workout wk = () -> {
            System.out.println("Hi");
        };
        wk.deadlift();

        interface Workout {
    public void deadlift();
}
        Functional Interface
            only one abstract method
        @FunctionalInterface
            interface Drawable{
                public void draw();
            }

        predefine functional interface
            Predicate
                public Boolean test(T t)
            Function
                public R apply(T t)
            Consumer
                public void accept(T t)
            Supplier
                public R get();
            BiPredicate
                public boolean test(T t, U u)
            BiFunction
                public R apply(T t, U t)


        Optional
            NPE
           empty(), of(), ofNullable()
     */
    public static void main(String[] args) {

    }

}
@FunctionalInterface
interface Drawable{
    public void draw();

    public default void drawCircle() {
        System.out.println("I am circle");
    }
}
