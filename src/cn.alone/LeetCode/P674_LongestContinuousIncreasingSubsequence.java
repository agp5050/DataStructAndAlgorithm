package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-10-05.
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 给定一个未排序的整数数组，找出最长的连续递增子序列的长度
 */
public class P674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0; // 最终的结果值
        int cur = Integer.MIN_VALUE; // 记录当前子序列的最大值
        int length = 0; // 当前子序列的长度
        for (int num : nums) {
            if (num > cur) { // 如果当前是递增子序列
                cur = num;
                length++;
            } else { // 递增子序列结束
                res = Math.max(res, length);
                length = 1;
                cur = num;
            }
        }
        res = Math.max(res, length);
        return res;
    }

}
