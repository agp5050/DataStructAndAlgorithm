package cn.alone.SwordToOffer;

import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-02.
 * 用两个栈实现队列
 */
public class QueueOfTwoStack {

    Stack<Integer> stack1 = new Stack<Integer>(); // 栈1 当做队尾
    Stack<Integer> stack2 = new Stack<Integer>(); // 栈2 当做队头

    /**
     * 入队，直接 push 进栈1
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 如果栈2 为空，那么将栈1中所有元素出栈并入栈2
     * 返回栈2的出栈
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (stack1.isEmpty() == false) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
