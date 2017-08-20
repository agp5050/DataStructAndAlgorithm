package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-20.
 * https://leetcode.com/problems/target-sum/
 * 给定一个数组和目标值 S，求有多少种方式用两个加号和一个减号以及5个数字算出目标值 S
 */
public class P494_TargetSum {

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (s > sum || (s + sum) % 2 > 0) {
            return 0;
        }
        return subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

}
