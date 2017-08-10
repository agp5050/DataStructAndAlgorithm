package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-10.
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * 给一个大小为 n 的非空数组，每次可以对 n - 1 个数字同时 +1，求出最少需要多少次可以使所有数字相同
 * 又是一道数学型的题。。。
 */
public class P453_MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }

}
