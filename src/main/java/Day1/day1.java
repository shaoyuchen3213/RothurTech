package Day1;

import org.w3c.dom.Node;

import java.util.*;

public class day1 {

    /*
        //1. Maven is a project managent tool that is used to manage the project's build, reporting and documentation from a central piece of information.
            maven install: compile, test, package, install
            maven deploy: compile, test, package, install, deploy
        //2. git is a version control system that is used to track changes in the source code during the software development process.

        //3. there is 8 data type in java
        byte(8), short, int(32), long(64), float, double, char, boolean
        and there also have wrapper datatype
        Byte, Short, Integer, Long, Float, Double, Character, Boolean

        autoboxing: converting a primitive data type to its corresponding wrapper class object like int to Integer
        unboxing: converting a wrapper class object to its corresponding primitive data type like Integer to int

        example:
        int a = 10;
        Integer b = a; // autoboxing
        int c = b; // unboxing

        4. String/ StringBuffer/ StringBuilder
        String is immutable, which means that once a string object is created, it cannot be changed.
        StringBuffer and StringBuilder are mutable, which means that once an object is created, it can be changed.

        StringBuffer is synchronized, which means that it is thread-safe.
        StringBuilder is not synchronized, which means that it is not thread-safe.

          String s = "abc";
        appendStr(s);
        System.out.println(s); // abc
        StringBuilder sb = new StringBuilder("abc");
        appendStr(sb);
        //String intern method is used to get the string from the string pool

        String a = new String("abc");
        String b = new String("abc");
        String c = "abc";
        String d = "abc";
        String e = b.intern();

        System.out.println(a == b); // false
        System.out.println(a == c); // false
        System.out.println(c == d); // true

        //when we use new it will create a new object in the heap memory
        //when we use "" it will create a new object in the string pool
        //intern() method is used to get the string from the string pool
        System.out.println(a == e); // false

        //Integer pool
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        system.out.println(a == b); // true
        because the integer pool is from -128 to 127
        system.out.println(c == d); // false

        5. Equal and hashcode
        equals() method is used to compare the content of the object
        hashcode() method is used to get the hashcode of the object
        so if we override the equals method, we should override the hashcode method, if we don't update the hashcode method, the hashcode method will return the memory address of the object


        class Node {
            int x;
            int y;
            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Node n1 = new Node(1, 2);
        Node n2 = new Node(1, 2);
        //true if not override equals method
        //
        System.out.println(n1.equals(n2)); // false
        System.out.println(n1 == n2 ); // false

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }

        6. Data Structure
        Collection vs Collestions
        Collection is an interface that represents a group of objects known as its elements.
        Collection: Queue, List, Set
            Queue: PriorityQueue, ArrayDeque, LinkedList
            List: ArrayList , LinkedList , Vector
            Set: HashSet, LinkedHashSet, TreeSet
            Map: HashMap, LinkedHashMap, TreeMap
            Hashmap: key-value pair, key is unique, key can be null, value can be null, is not thread safe
            Hashtable: key-value pair, key is unique, key can not be null, value can not be null, is thread safe, lock whole object
            ConcurrentHashMap: key-value pair, key is unique, key can not be null, value can not be null, is thread safe, lock only part of object
            different arraylist and linkedlist: arraylist is faster in get, linkedlist is faster in add and remove
         Stack


         7. Comparable vs Comparator
            Comparable is used to compare the current object with another object.
            Comparator is used to compare two different objects.
           different between comparable and comparator:



          class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Set<Node> set = new TreeSet<Node>(Comparator.comparing(node -> node.x));
        set.add(new Node(1, 1));
        set.add(new Node(2, 2));
        set.add(new Node(3, 3));
        set.add(new Node(4, 4));
        System.out.println(set.size()); // 1





    }


    public static void appendStr(StringBuilder sb) {
        sb = sb.append("def");
    }
        */

    public static void main(String[] args) {
//        System.out.println("Hello World");
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("apple", 5);
//        map.put("banana", 10);
//        for(Map.Entry<String, Integer> me : map.entrySet()) {
//            System.out.println(me.getKey() + ":");
//            System.out.println(me.getValue());
//        }
//        System.out.println(map.get("banana"));
//
//        // List example
//        List<String> list = new ArrayList<>();
//        list.add("apple");
//        list.add("banana");
//        list.add("apple"); // duplicates allowed
//        System.out.println(list); // Output: [apple, banana, apple]
//        Collections.sort(list);
//        Collections.reverse(list);
//        Collections.max(list);
//        System.out.println(list);
//// Set example
//        Set<String> set = new HashSet<>();
//        set.add("apple");
//        set.add("banana");
//        set.add("apple"); // duplicate ignored
//        System.out.println(set); // Output: [banana, apple] (order not guaranteed)
//
//        //i.	String vs StringBuilder vs StringBuffer
//
//        String str = "Hello";
//        str = str + "world";  //Create a new object

//        StringBuilder sb = new StringBuilder("Hello");
//        sb.append("abd");
//        sb.append("cad");
//        sb.toString();
//        System.out.println(sb);
//
//        StringBuffer sb1 = new StringBuffer("11231");
//        sb1.append("2622");
//        System.out.println(sb1);

        //Usage
//        List<Student> list = new ArrayList<>();
//        // only sort in default order, and two object must have same instance
//        Collections.sort(list);
//
//        Comparator<Student> nameComparator = (a, b) -> a.name.compareTo(b.name);
//        Collections.sort(list, nameComparator);


    }
    // Comparable

//    public class Student implements Comparable<Student> {
//        int id;
//        String name;
//        public Student(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        @Override
//        public int compareTo(Student other) {
//            return Integer.compare(this.id, other.id);
//        }


    //    }
//Overloading
    class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public double add(double a, double b) {
            return a + b;
        }
    }



    public class Person {
//        private final String name;
//        private final int age;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return this.name;
//        }
        public void makeSound() {
            System.out.println("I am Person");
        }
    }


    class Man extends Person {
        @Override
        public void makeSound() {
            System.out.println("I am girl");
        }
    }
}


