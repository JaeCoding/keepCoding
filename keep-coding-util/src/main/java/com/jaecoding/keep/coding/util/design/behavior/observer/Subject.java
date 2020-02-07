package com.jaecoding.keep.coding.util.design.behavior.observer;

/**
 * @author Jae
 */
public interface Subject {
    /**
     * 注册一个新的观察者
     *
     * @param o 观察者
     */
    void registerObserver(Observer o);

    /**
     * 通知它的观察者一个新闻的到来
     *
     * @param tweet 新闻
     */
    void notifyObservers(String tweet);
}
