package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-13.
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * 给定一个数组 nums 和 整数 k，找出连续的 k 个数中平均值最大的值
 */
public class P643_MaximumAverageSubarrayI {

    /**
     * 类似于滑动窗口最大值
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < k; i++) { // 先找出前 k 个值的和
            sum += nums[i];
        }
        double res = sum / k; // 前 k 个数的平均值
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            res = Math.max(res, sum / k);
        }
        return res;
    }

}
