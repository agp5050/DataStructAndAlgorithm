package LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/3sum-closest/
 * 和 ThreeSum 类似，每次先确定一个数的值，然后计算选出来的两个数和当前确定的数的和，
 * 再和目标值进行比较，如果和目标值相同，则返回目标值，
 * 否则继续计算选取更接近的值作为结果值。直到找到和目标值相同的值或者计算完毕
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        // 初始化res为前三个数之和
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length - 2; ) {
            // 当前计算的3个数的和
            int sum = 0;
            // 从i后一个结点开始查找
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 如果当前3个数的值更接近target
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                // 如果找到的和目标相等，直接返回
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    int num = nums[left];
                    while (num == nums[left] && left < right) {
                        left++;
                    }
                } else {
                    int num = nums[right];
                    while (num == nums[right] && right > left) {
                        right--;
                    }
                }
            }
            // 跳过重复的
            int num = nums[i];
            while (i < length && nums[i] == num) {
                i++;
            }
        }
        return res;

    }

}