package cn.alone.LeetCode;

import java.util.*;

/**
 * Created by RojerAlone on 2017-08-11.
 * https://leetcode.com/problems/next-greater-element-ii/
 * 给定一个数组，找出这个数组中大于当前元素的值，如果没有则为 -1
 */
public class P503_NextGreaterElementII {

    /**
     * 用栈存储遍历过的坐标，栈顶存放的是已经遍历过但是没有找到结果的坐标
     * 每次遍历到一个数，查看当前数是不是大于栈顶下标对应的数，如果是就找到了
     * 记录取栈顶的数，知道栈空或者当前数不是目标值，继续遍历
     * 遍历的时候遍历 2 * 数组长度，但是第二次遍历的时候不需要再记录下标了
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>(); // 栈内存放的是当前没有找到结果的坐标
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; // 记录第 i 个值
            while (!stack.isEmpty() && nums[stack.peek()] < num) { // 如果栈非空同时前边的值小于当前值，当前值就是结果值
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

}
