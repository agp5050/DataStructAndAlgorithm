package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/array-partition-i/
 * 题目没看太懂，就是将数组排序，然后隔一个数取值求和就可以了
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int res = 0;
        // 输入数据合法性判断
        if (nums == null || nums.length % 2 == 1) {
            return -1;
        } else if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

}
