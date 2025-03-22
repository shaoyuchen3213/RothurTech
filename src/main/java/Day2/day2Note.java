package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day2Note {
    /*
       1. Java, compile once, run anywhere
       .java file -> .class file -> JVM

       2. JVM Architecture
       Class Loader
       Bootstrap Class Loader Extension Class Loader       Application Class Loader
       java.land.*             JAVA_HOME/jre/lib/rt.jar     load files present on the classPath
       jave.util.*             JAVA_HOME/jre/lib/ext/*.jar  load files present on the classPath

       parents delegation model
       app -> ext -> bootstrap

       Runtime data area
       Method Area: all class level data, runtime constat pool, field and method data, method code
       Heap Area: all objects and their corresponding instance variables and arrays are stored
       Stack Area: all local variables and partial results are stored
       PC Registers: program counter registers, multiple threads are executed
       Native Method Stack: all the native method information


       // Execution engine
       Interpreter: read bytecode and execute line by line
       JIT Compiler: improve the performance of the interpreter
       Garbage Collector: destroy the object which is no longer in use
        GC: Mark and Sweep, Copy, Mark and Compact, Stop and Copy
               type:
               Serial GC: single thread, stop the world
               Parallel GC: multiple threads, stop the world
               G1 GC: multiple threads, low pause time

               CMS GC: multiple threads, low pause time

         JNI: Java Native Interface


         3. reserved words
          reserved word is a word that has a special meaning in java
          reserved literals: true, false, null
          keyword(50):
          modifers: public, private, protected, static, final, abstract, synchronized, volatile, transient, native, strictfp
             class related: class, interface, extends, implements, enum, package, import
               object related: new, this, super
               method related: void, return, throws
               exception related: try, catch, finally, throw, throws
               loop related: for, while, do, break, continue


          final
             final class: cannot be inherited, can't modify
             final int a = 1;
        a = 2; // error;

                   // we can add item to the list, but we can't change the reference of the list
       final ArrayList<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);

         //final method, if the method is final, it cannot be overridden
       class A {
           final void show() {
               System.out.println("A");
           }
       }
       class B extends A {
           //it will occur an error
           void show() {
               System.out.println("B");
           }
       }


        //final class, if we make a final class, it cannot be inherited
       final class A {
           void show() {
               System.out.println("A");
           }
       }
       // class B can't inherit class A

       class B extends A {
           void show() {
               System.out.println("B");
           }
       }
       //how to create immuatable class
       - final class
               - private field
               - no setter only getter
               - deep copy of the object

         finalize: method is used to perform clean up processing just before the object is garbage collected

         use of static keyword
           - static variable: the value of the variable is shared among all the objects of the class
           - static method: the method belongs to the class and not to the object
           - static block: used to initialize the static variables, and it is executed before the main method
           static {
               //code
           }

           - static class: nested class is a static class
           public static class A {
               //code
           }
        System.out.println(a);
       show();
   }
   static int a = 10;
   static {
       System.out.println("static block is invoked");
       System.out.println(a);
   }
   public static void show() {
       System.out.println("show");
   }

   class A {
       public void method2(){
           day2Note.show();
       }
   }

   implment and extends
   implment is used to implement an interface
   extends is used to extend a class


   4. OOP
   - Encapsulation: wrapping up of data into a single unit
       declare the variables of a class as private, setter and getter methods
       class A {
           private int a;
           public void setA(int a) {
               this.a = a;
           }
           public int getA() {
               return a;
           }

   - Inheritance: one class acquires the properties and behavior of another class
       class A {
           int a;
           void show() {
               System.out.println("A");
           }
       }
       class B extends A {
           int b;
           void display() {
               System.out.println("B");
           }
       }

   - Polymorphism: one name and multiple forms
       - compile time polymorphism: method overloading    //same method name, different parameters
       class A {
           public void method() {
               System.out.println("A");
           }
           public void method(int a) {
               System.out.println("A" + a);
           }
      }
       - runtime polymorphism: method overriding          //same method name, same parameters
          //method overriding
        class A {
             public void method() {
                   System.out.println("A");
             }
        }
         class B extends A {
             public void method() {
                   System.out.println("B");
             }
        }
   - Abstraction: hiding the implementation details
           //abstract class, abstract method, interface
           different between abstract class and interface: abstract class can have constructor, interface can't have constructor
           abstract class can have method body, interface can't have method body
           abstract class can have final, non-final, static, non-static variables, interface can have only final, static variables
    we can never override the static method, but we can hide the static method
A obj = new C(); //upcasting
   }

   class A {
        public void method() {
           System.out.println("in class A");
       }
   }
   class B extends A {
       public void method() {
           System.out.println("in class B");
       }
   }
   class C extends B {

   }

        */
//    public void main(String[] args) {
//        final int a = 1;
//        //error a = 2;
//    }
//   class A {
//        final int add(int a, int b) {
//            return a + b;
//        }
//   }
//   //error
////   class B extends A {
////        @Override
////       int add(int a, int b) {
////            return a - b;
////        }
////   }
//    final class Human {
//        void makeSound() {
//            System.out.println("I am Human");
//        }
//   }
//   //error
////   class Man extends Human {
////
////   }

    public static void main(String[] args) {

    }
    public final class Student {
        final int id;
        final String fName;
        final String lName;
        final List<Course> courses;
        public Student(int id, String fName, String lName, List<Course> courses) {
            this.id = id;
            this.fName = fName;
            this.lName = lName;
            this.courses = Collections.unmodifiableList(new ArrayList<>(courses));
        }
        public String getName() {
            return this.fName;
        }
        public List<Course> getCourse() {
            return courses;
        }
    }
    public class Course {
        private int id;
        private String course_Name;
        public Course(int id, String course_Name) {
            this.id = id;
            this.course_Name = course_Name;
        }

        public String getCourse_Name() {
            return this.course_Name;
        }
        public void set_Course(int id, String course_Name) {
            this.id = id;
            this.course_Name = course_Name;
        }
    }
}
