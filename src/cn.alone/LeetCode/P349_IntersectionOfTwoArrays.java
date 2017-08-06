package cn.alone.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-08-06.
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 找出两个数组的交集
 */
public class P349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> tmp = new HashSet<Integer>(); // 记录结果集
        for (int num : nums1) {
            set.add(num);
        }
        int nums = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)]; // 假设结果集很大，最后的时候再截取，而不是遍历 set
        for (int num : nums2) {
            if (set.contains(num)) {
                if (!tmp.contains(num)) { // 如果结果集中不存在这个数再加入
                    res[nums] = num;
                    nums++;
                    tmp.add(num);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, nums);
    }

}
