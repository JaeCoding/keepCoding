package com.jaecoding.keep.coding.util.design.structure.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 优点：真实对象不用必须实现接口
 */
public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成 CGLIB 代理对象 / 建立关系 真实对象-Enhancer-CglibProxy（生成代理类）
     * @param cls 真实对象 的 类
     * @return 增强者 创造个代理对象
     */
    public Object getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        //设置 enhancer 的父类 为 真实对象
        enhancer.setSuperclass(cls);
        //设置 enhancer 回调 为 此MethodInterceptor实现类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 代理逻辑方法 类似invoke
     * @param proxy 代理对象
     * @param method 真实对象 的方法
     * @param args 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象前，插入的方法");
        //相当于 真实对象的方法调用,通过反射实现
        Object object = methodProxy.invokeSuper(proxy, args);
        System.out.println("在调度真实对象后，插入的方法");
        return object;
    }


}
