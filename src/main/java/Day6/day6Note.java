package Day6;

public class day6Note {
    public static void main(String[] args) {

    }
}

//eager loading
class Singleton1 {
    private static final Singleton1 instance= new Singleton1();

    private Singleton1() {

    }
    public static Singleton1 getInstance() {
        return instance;
    }
}


//lazing loading
class Singleton2 {
    //volatitle to prevent instruction reorder
    private static volatile  Singleton2 instance;

    //private constructor to prevent instantiation from other class
    private Singleton2() {}


    //not thread safe
    public static Singleton2 getInstance() {
        if (instance == null) { //first check(no locking for the instance)
            synchronized (Singleton2.class) {
                if(instance == null) {  //second check with locking
                    instance = new Singleton2();
                    //1 create instance reference
                    //2 new singleton
                    //instance reference points to instance object,
                    // 1 -> 2 -> 3
                    // 1 -> 3 -> 2

                }
            }

        }
        return instance;
    }
}
