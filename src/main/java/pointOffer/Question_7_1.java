package pointOffer;

import java.util.Stack;

/**
 * 变种：利用两个队列 实现栈的功能
 * 思想：只有一个队列存数，另一个队列辅助。
 */
public class Question_7_1 {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    boolean flag = false; //false表示当前处于queue1，true表示处于queue2

    //添加功能，直接在flag表示当前有数的数列添加
    public static void push(int num) {
        stack1.push(num);
    }

    //删除功能，将当前数列数全部移至另一数列，弹出最后一个数


}
