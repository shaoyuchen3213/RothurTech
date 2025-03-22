package Day3;
import java.util.*;
public class OptionalDemo {
    public static void main(String[] args) {
        //1. ofNullable: wrap a value that may be null
        String name = getUserName();
        Optional<String> optionalName = Optional.ofNullable(name);

        //2. orElse: provide a default value if optional is empty
        String result1 = optionalName.orElse("Guest");
        System.out.println("Name with orElse " + result1);

        //3. orElseThrow: throw an exception if optional is empty
        try{
            String result2 = optionalName.orElseThrow(() -> new IllegalArgumentException("User is missing"));
            System.out.println("Name with orEl" +
                    result2);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
    }

    private static String getUserName() {
        return null;
    }
}
@FunctionalInterface
interface myFuncion {
    void execute(); //only one abstract method allowed
}
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
