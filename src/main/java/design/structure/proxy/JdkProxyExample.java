package design.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jae
 */
public class JdkProxyExample implements InvocationHandler {

    private Object target = null;

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method 当前调度方法，也就是真实对象的方法
     * @param args 方法参数
     * @return 代理结果返回
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象前，插入的方法");
        //相当于 真实对象的方法调用,通过反射实现
        Object object = method.invoke(target, args);
        System.out.println("在调度真实对象后，插入的方法");
        return object;
    }

    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
