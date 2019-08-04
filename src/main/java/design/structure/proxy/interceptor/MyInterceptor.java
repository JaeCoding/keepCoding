package design.structure.proxy.interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("before the method");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("replace the proxied method");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {

        System.out.println("after method");
    }
}
