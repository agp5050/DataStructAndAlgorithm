package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-08-06.
 * https://leetcode.com/problems/assign-cookies/
 * 给小朋友分饼干，每个小朋友胃口不同，饼干大小也不同，但是每个小朋友只能分到一个饼干
 * 给定小朋友的胃口和饼干大小，求出能分给多少个小朋友
 */
public class P455_AssignCookies {

    /**
     * 排序，然后分饼干，如果这个小朋友不够吃，就换更大的饼干，也就是遍历两个数组
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = 0; // 记录分到了第几块饼干
        for (int child : g) {
            if (index >= s.length) {
                break;
            }
            if (s[index] >= child) {
                res++;
                index++;
            } else {
                while (index < s.length && s[index] < child) {
                    index++;
                }
                if (index >= s.length) {
                    break;
                } else {
                    res++;
                    index++;
                }
            }
        }
        return res;
    }

}
