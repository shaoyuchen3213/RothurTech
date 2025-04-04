package Day6;

import java.beans.BeanProperty;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
}

class RunningTestInstance {
    private String val;

    public RunningTestInstance() {
        this.val = "12345";
    }

    public void method1() {
        System.out.println("the value is " + val);
    }

    public void method2(int n) {
        System.out.println("the number is " + n);
    }

    private void method3() {
        System.out.println("private method");
    }

    @BeanProperty
    public void method() {
        System.out.println("method with annotation");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        RunningTestInstance obj = new RunningTestInstance();
        Class cls = obj.getClass();

        System.out.println("the name of the  class is " + cls.getName());
        Constructor constructor = cls.getConstructor();

        Method[] methods = cls.getMethods();
        System.out.println(Arrays.toString(methods));
    }
}
