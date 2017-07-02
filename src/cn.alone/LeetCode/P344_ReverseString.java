package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/reverse-string/
 * 输入一个字符串，返回字符串内字符反转顺序后的字符串
 */
public class P344_ReverseString {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return new String(chars);
    }

}
