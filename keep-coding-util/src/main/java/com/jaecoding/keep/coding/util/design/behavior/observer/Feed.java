package com.jaecoding.keep.coding.util.design.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jae
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    /**
     * 注册一个新的观察者
     *
     * @param o 观察者
     */
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    /**
     * 通知每一个 所注册的观察者 一个新闻的到来
     *
     * @param tweet 新闻
     */
    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
