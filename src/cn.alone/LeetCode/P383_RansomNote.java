package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/ransom-note/
 * 给两个字符串，如果第二个字符串包含第一个字符串，返回 true，否则返回 false
 */
public class P383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        int[] arr = new int[26];
        // 遍历第二个字符串中的所有字符，记录每个字符出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        // 遍历第一个字符串，看第二个字符串中是否有足够的字符串
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
