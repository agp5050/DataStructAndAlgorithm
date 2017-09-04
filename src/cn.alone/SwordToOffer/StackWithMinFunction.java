package cn.alone.SwordToOffer;

import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-04.
 * 包含 min 函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackWithMinFunction {

    Stack<Integer> minStack = new Stack<>(); // min 栈顶元素为当前的最小值
    Stack<Integer> stack = new Stack<>();

    /**
     * 如果当前入栈的数字小于等于 min 栈的栈顶元素，也就是当前最小元素，将当前入栈的数字入栈 min 栈
     * 如果出栈时当前数字为当前最小值，并且上一个最小值和当前最小值相同，如果 min 栈内只有一个当前最小值，
     * 出栈后下次就没有了，因此如果当前数字等于最小值，也要入 min 栈
     */
    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else if (node <= minStack.peek()) {
            minStack.push(node);
        }
    }

    /**
     * 出栈时，如果当前栈顶元素等于当前最小值，那么 min 栈顶元素也要出栈
     */
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (minStack.peek() == stack.pop()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
