package cn.alone.SwordToOffer;

import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-04.
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4，5,3,2,1 是该压栈序列对应的一个弹出序列，
 * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPushPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (stack.isEmpty() == false && stack.peek() == popA[index]) { // 模拟入栈出栈过程
                stack.pop();
                index++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
