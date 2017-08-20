package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-20.
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 给定一个数组，判断是否可以转化为两个子数组，这两个子数组的和相同
 */
public class P416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) { // 不能被 2 整除，也就不能转化为两部分的和
            return false;
        }
        int target = sum / 2;
        int length = nums.length;
        // 找出数组中是否有子数组的和为整个数组和的一半
        int[][] dp = new int[length + 1][target + 1];
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[length][target] == 1;
    }

}
