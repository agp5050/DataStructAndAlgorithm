package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 * 给出两个字符串，找出“最长不公共子序列”的长度，
 * 也就是第一个不是第二个或者第二个不是第一个子集中最长的
 * 如果不存在这样的子序列，返回-1
 * 一道水题。。。
 */
public class P521_LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
