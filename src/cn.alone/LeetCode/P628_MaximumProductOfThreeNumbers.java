package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-08-13.
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 * 类似于 P643 _MaximumAverageSubarrayI 滑动窗口最大值同类问题
 * 给定一个数组，找出任意 3 个数乘积的最大值
 */
public class P628_MaximumProductOfThreeNumbers {

    /**
     * 排序后比较最大的三个数的乘积和最小的两个和最大的乘积
     * 如果全是负数或者全是正数或者只有一个负数，最大的三个数的乘积就是结果值
     * 如果有两个及以上的负数，最小的两个数的乘积是正数，再和最大的数相乘，然后比较最大的三个数的乘积即可
     */
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[0] * nums[1] * nums[length - 1]);
    }

}
