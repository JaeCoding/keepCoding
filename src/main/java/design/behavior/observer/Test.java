package design.behavior.observer;

public class Test {
    public static void main(String[] args) {
        Subject f = new Feed();
        //这里是否有点问题，应该是让观察者来主动订阅目标对象
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action! money wine");

        //Observer实例实现函数式接口，可以不实现，直接用lambda表示（不过貌似可读性不太好）
        f.registerObserver(string -> {
            if (string != null && string.contains("money")) {
                System.out.println("Breaking news in NY! " + string);
            }
        });
        /*
        可见，要Lambda适配得很好，那是因为需要 执行的动作都很简单，
        观察者的逻辑有可能十分复杂，它们可能还持有状态，抑或定义了多个方法，诸如此类
        在这些情形下，你还是应该继续使用类的方式。而不是lambda
         */


    }
}
