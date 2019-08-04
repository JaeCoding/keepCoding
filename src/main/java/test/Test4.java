package test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 彭文杰
 * @create: 2018-09-11 17:24
 **/
public class Test4 {

}

class B implements A {
    @Override
    public void f() {}
    public void g() {}
}

class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
//     a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
} /* Output:
B
*///:~
