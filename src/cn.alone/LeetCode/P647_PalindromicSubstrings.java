package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-01.
 * https://leetcode.com/problems/palindromic-substrings/
 * 给一个字符串，找出子串中回文串的个数
 */
public class P647_PalindromicSubstrings {

    private int res = 0;

    /**
     * 比如回文串 aba ，从 b 开始，一个指针在左，一个指针在右，分别向左右移动，如果两个指针的字符相同，就是一个回文子串
     * 比如回文串 abba ，一个指针指向左边的 b，一个指针指向右边的 b，分别向左右移动，如果两个指针的字符相同，就是一个回文子串
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            countPalindromic(s, i, i); // 对应 abba 的情况
            countPalindromic(s, i, i + 1); // 对应 aba 的情况
        }
        return res;
    }

    public void countPalindromic(String s, int left, int right) {
        // 如果两个指针的字符相等，就是一个子回文串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
    }

}
