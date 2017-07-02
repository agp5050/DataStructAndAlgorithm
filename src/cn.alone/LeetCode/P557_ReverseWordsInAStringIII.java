package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Reverse String 的变种，根据空格划分句子中的单词，然后再对每个单词调用 Reverse String
 */
public class P557_ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        String[] strs = s.split(" ");
        for (String str : strs) {
            res += reverseWord(str) + " ";
        }
        return res.substring(0, res.length() - 1);  // 减去后边多余的空格
    }

    private String reverseWord(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return new String(chars);
    }

}
