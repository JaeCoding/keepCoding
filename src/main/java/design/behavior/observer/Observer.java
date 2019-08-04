package design.behavior.observer;

/**
 * 很明显是函数式接口  试试lambda？
 *
 * @author Jae
 */
public interface Observer {

    /**
     * 观察者根据消息 作出不同反应
     *
     * @param tweet 所获取的消息
     */
    void notify(String tweet);
}
