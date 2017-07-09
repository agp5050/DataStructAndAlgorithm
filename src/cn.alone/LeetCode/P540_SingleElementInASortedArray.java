package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 给一个排序过的数组，每个数字出现两次只有一个数字只出现了一次，求这个数字
 * 和 136 题一样
 * 但是在讨论区看到了更简单的解法，时间复杂度只有 O(logN)
 */
public class P540_SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     * 利用数组排序过的特性进行二分查找
     * @param nums
     * @return
     */
    public int singleNonDuplicateOfLogN(int[] nums) {
        // 二分查找
        int n = nums.length, low = 0, high = n / 2;
        while (low < high) {
            int m = (low + high) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) {
                high = m;
            } else {
                low = m + 1;
            }
        }
        return nums[2 * low];
    }

}
