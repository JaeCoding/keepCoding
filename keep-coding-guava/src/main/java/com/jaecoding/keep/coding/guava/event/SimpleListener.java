package com.jaecoding.keep.coding.guava.event;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/27
 * @since 1.8
 */
public class SimpleListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleListener.class);

    /**
     * 一个简单的Listener方法
     * 例如 打日志
     * @param event Guava规定此处只能有一个参数
     */
    @Subscribe
    public void handleString(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received handleString event [{}] and will take a action", event);
        }
    }

    /**
     * 一个简单的Listener方法
     * 例如 打日志
     * @param event Guava规定此处只能有一个参数
     */
    @Subscribe
    public void handleInteger(final Integer event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received handleInteger event [{}] and will take a action", event);
        }
    }


}
