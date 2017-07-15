package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/15.
 * https://leetcode.com/problems/find-the-difference/
 * 给两个只包含小写字母的字符串，第二个字符串是第一个字符串加上一个额外的字母后又打乱顺序
 * 找出加的这个字母
 */
public class P389_FindTheDifference {

    /**
     * 同 P136_SingleNumber 类似，运用异或的特性，一个数异或自己等于0
     */
    public char findTheDifference(String s, String t) {
        // 取出t的最后一个字符后，s和t的长度就一样了
        char c = t.charAt(t.length() - 1);
        for (int i = 0 ; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

}
