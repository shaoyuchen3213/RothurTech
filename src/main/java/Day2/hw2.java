package Day2;

//
//    class CFG extends Thread {
//        //using volatile
//        volatile boolean working = true;
//
//        //if non-volatile it will sleep in main and runtime error will occur
//        public void run() {
//            long count = 0;
//            while(working) {
//                count++;
//            }
//            System.out.println("Thread terminated."
//                    + count);
//        }
//        public static void main(String[] args) throws InterruptedException{
//
//            CFG test = new CFG();
//            test.start();
//            Thread.sleep(100);
//            System.out.println("After sleeping in Main");
//            test.working = false;
//            test.join();
//            System.out.println("working set to" + test.working);
//        }
//    }


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.Serializable;
//
//class Test implements Serializable {
//
//    // Making Accesskey transient for security
//    transient String accessKey;
//
//    // Making age transient as age can be
//    // calculated from Date of Birth
//    // and current date.
//    transient int age;
//
//    // serialize other fields
//    String name, address;
//    public Test(String accessKey, int age,
//                String name, String address)
//    {
//        this.accessKey = accessKey;
//        this.age = age;
//        this.name = name;
//        this.address = address;
//    }
//}

class hw2 {
//    public void checkAge(int age) {
//        if(age < 18) {
//            throw new IllegalArgumentException("Age must be 18+");
//        }
//    }
//
//    public void readFile(String filedName) throws IOException {
//        //SOME FILE I/O  CODE THAT MIGHT THROWS EXCEPTION
//        FileReader file = new FileReader(filedName);
//    }


    public static void main(String[] args) {
        class Animal {
            String face;
            Animal(String face) {
                this.face = face;
            }
            void displayFace() {
                System.out.println("Face 1"+ this.face);
            }
        }
        class Dog extends Animal {
            Dog(String face) {
                super(face);
            }
            @Override
            void displayFace() {
                super.displayFace();
                System.out.println(this.face);
            }
        }
        Animal a = new Animal("black");
        a.displayFace();
        Animal b = new Dog("white");
        b.displayFace();
    }
    abstract class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        // Abstract method
        abstract void makeSound();

        // Concrete method
        public void sleep() {
            System.out.println(name + " is sleeping.");
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Woof!");
        }
    }
    interface Walkable {
        void walk(); // implicitly public and abstract
    }

    interface Swimmable {
        void swim();
    }

    class Human implements Walkable, Swimmable {
        public void walk() {
            System.out.println("Human is walking.");
        }

        public void swim() {
            System.out.println("Human is swimming.");
        }
    }

}