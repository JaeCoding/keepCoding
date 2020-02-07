package com.jaecoding.keep.coding.util.design.behavior.responsibility;

/**
 * 抽象类
 * 加泛型：输入任务的类型是不确定的  泛型T
 * 根据具体实现 标明
 *
 * @author Jae
 */
public abstract class ProcessingObject<T> {

    /**
     * 用于记录后续 处理者对象
     */
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    /**
     * 处理完后  交给下一个处理
     *
     * @param input 泛型任务
     * @return 经过了所有处理后 的 最后结果
     */
    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}