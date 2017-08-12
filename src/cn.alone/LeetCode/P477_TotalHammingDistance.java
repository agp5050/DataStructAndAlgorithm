package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-12.
 * https://leetcode.com/problems/total-hamming-distance/
 * Hamming Distance 的变种，给定数组，计算两两之间的汉明距离的和
 */
public class P477_TotalHammingDistance {

    /**
     * 本质上就是求出所有的数的二进制 (0 的个数 * 1 的个数) 的和
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) { // 32 位整数，遍历32次
            int bitCount = 0;
            for (int j = 0; j < n; j++) {
                bitCount += (nums[j] >> i) & 1; // 右移一定的位数再和 1 相与，最后一位是否是 1
            }
            res += bitCount * (n - bitCount); // 0 的个数 * 1 的个数
        }
        return res;
    }

}
