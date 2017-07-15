package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/15.
 * https://leetcode.com/problems/detect-capital/
 * 给定一个字符串，判断是否全是大写或者全是小写或者只有第一个字符是大写
 */
public class P520_DetectCapital {

    /**
     * 如果第一个小写第二个大写，返回错误
     * 否则判断第二个以后的字符是否和第二个字符一样大写或者小写
     */
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        } else if (word.length() == 1) {
            return true;
        }
        boolean first = 'A' <= word.charAt(0) && word.charAt(0) <= 'Z';
        boolean second = 'A' <= word.charAt(1) && word.charAt(1) <= 'Z';
        // 如果第一个小写第二个大写，返回错误
        if (first == false && second == true) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (('A' <= word.charAt(i) && word.charAt(i) <= 'Z') != second) {
                return false;
            }
        }
        return true;
    }

}
