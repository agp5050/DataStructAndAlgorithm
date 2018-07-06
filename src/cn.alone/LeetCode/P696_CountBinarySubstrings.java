package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2018-07-06
 * 给定一个只包含0和1的字符串,计算子字符串中有相同个数的 0 和 1 的子串的个数(要求子串中的 0 和 1是连续的,并且不去重)
 */
public class P696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int res = 0;
        int preLength = 0;
        int curLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                curLength++;
            } else {
                preLength = curLength;
                curLength = 1;
            }
            if (preLength >= curLength) {
                res++;
            }
        }
        return res;
    }

}
