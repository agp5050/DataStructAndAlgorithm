package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-05.
 * https://leetcode.com/problems/generate-parentheses/
 * 给一个数字表示小括号的个数，给出一共能组成的不同的括号组合
 */
public class P022_GenerateParentheses {

    /**
     * 递归
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String str, int left, int right, int n) {
        if (str.length() == n * 2) { // 已经找到了字符串，加入结果集中，返回
            res.add(str);
            return;
        }
        if (left < n) { // 先从左括号找起
            helper(res, str + "(", left + 1, right, n);
        }
        if (right < left) { // 补上右括号的
            helper(res, str + ")", left, right + 1, n);
        }
    }

}
