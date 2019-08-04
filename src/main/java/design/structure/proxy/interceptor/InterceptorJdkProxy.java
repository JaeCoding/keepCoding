package design.structure.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 带拦截器
 */
public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;

    private String interceptorClassName = null;

    public InterceptorJdkProxy(Object target, String interceptorClassName) {
        this.target = target;
        this.interceptorClassName = interceptorClassName;
    }

    /**
     * 代理方法逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke the original method if set not the interceptor
        if (interceptorClassName == null) {
            return method.invoke(proxy, args);
        }
        Object result = null;
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClassName).newInstance();
        // 拦截器 分析方法是否拦截逻辑
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(proxy, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return result;
    }

    public static Object bind(Object target, String interceptorClassName) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClassName)
        );
    }





}
