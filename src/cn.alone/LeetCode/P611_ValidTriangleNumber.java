package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-08-28.
 * https://leetcode.com/problems/valid-triangle-number/
 * 给一个数组，判断数组中的数作为边长可以组成多少个三角形
 */
public class P611_ValidTriangleNumber {

    /**
     * 关键点：如果两个短边的和大于第三边，那么三角形成立，两个短边再长一点还是可以成立的
     * 先对数组进行排序，使用两个基本点，然后从大到小遍历，只要当前最小的点符合，那么最小点到次小点都符合
     * 然后次小的点减一，继续遍历
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) { // 如果组成三角形（两边之和大于第三边），那么从 left 到 right 的都符合
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
