package com.jaecoding.keep.coding.algorithm.point;


import java.util.Stack;

/**
 * 用两个栈实现队列的功能，有尾加和头删功能
 * 想一想你玩过的弹簧玩具，左右手各持一边
 */
public class Question_7 {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    //添加功能，只在左边的stack1中添加
    public static void enQueue(int num) {
        stack1.push(num);
    }

    //删除功能，在右边栈顶弹出，若为空，则将左栈依次压入右栈
    public static int deQueue() throws Exception {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return Integer.parseInt(null);
//                throw new Exception();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }


}
