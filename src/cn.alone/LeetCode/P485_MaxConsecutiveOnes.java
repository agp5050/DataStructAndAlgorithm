package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/max-consecutive-ones/
 * 给一个二进制数组，也就是数组中只包含0和1
 * 求出最大的连续1的个数
 */
public class P485_MaxConsecutiveOnes {

    /**
     * LeetCode 上好多这种水题
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > res) {
                    res = count;
                }
                count = 0;
            }
        }
        // 最后再计算一次
        if (count > res) {
            res = count;
        }
        return res;
    }

}
