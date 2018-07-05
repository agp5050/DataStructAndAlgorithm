package cn.alone.LeetCode;

import java.util.Stack;

/**
 * Created by RojerAlone on 2018-07-05
 * 一对括号为 1 分，括号扩住的部分分数翻倍，给定一个括号字符串，求分数
 */
public class P856_ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
