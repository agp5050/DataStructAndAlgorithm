package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/fizz-buzz/
 * 输入一个正整数，输出从1到这个整数之间的所有数字，
 * 但是如果某数字能被3整除，用 Fizz 替换，如果某数字能被5整除，用 Buzz 替换，
 * 如果这个数字能同时被3和5整除，那么输出 FizzBuzz
 */
public class P412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
