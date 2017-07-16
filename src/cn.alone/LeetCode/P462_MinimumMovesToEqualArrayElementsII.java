package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017/7/16.
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 给一个非空的数组，将所有数字都变成同样的一个数，但是每次只能加1或者减1
 * 求最少移动次数
 */
public class P462_MinimumMovesToEqualArrayElementsII {

    /**
     * 排序，找到中间大小的数，最终结果就是这个数
     * 只需要遍历，每次加上当前值和中间值的差值即可
     * 如果个数是单数，就是中间的数 1，2，3，4，5 -> 3
     * 如果个数是双数，中间的两个数二选一 1，2，3，4，5，6 -> 3 或者 4
     */
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        int num = nums[nums.length / 2];
        for (int i : nums) {
            res += Math.abs(i - num);
        }
        return res;
    }

    /**
     * 第二种解法
     * 排序，两个指针，一个指向开头，一个指向结尾
     * 每次结果值加上这两个数的差，直到两个指针相遇
     */
    public int _minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            res += Math.abs(nums[left] - nums[right]);
            ++left;
            --right;
        }
        return res;
    }

}
