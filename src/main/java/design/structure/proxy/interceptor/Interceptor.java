package design.structure.proxy.interceptor;

import java.lang.reflect.Method;

public interface Interceptor {

    /**
     * 拦截器 的 拦截方法
     * 真实对象方法执行前调用
     * 若返回true 则反射调用 真实对象方法
     * 若返回false 则执行around()
     *
     * 执行around或真实对象方法后 会调用after()
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy, Object target, Method method, Object[] args);
}
