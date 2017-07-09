package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/arithmetic-slices/
 * 输入一个数组，返回这个数组中等差数列的个数（等差数列最少有3个数）
 */
public class P413_ArithmeticSlices {

    /**
     * 一个等差数列有 (1 + 2 + 3 + ... + n) 个等差子序列
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0;
        int length = 2;
        int difference = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == difference) { // 如果是等差的，长度+1，继续
                length++;
                continue;
            } else { // 如果不继续等差，计算找到的这个等差数列的子序列个数，并清除计算数据
                if (length >= 3) {
                    length = length - 2;
                    if (length % 2 == 0) {
                        res += (length + 1) * (length / 2);
                    } else {
                        res += (length + 1) * (length - 1) / 2 + length / 2 + 1;
                    }
                }
                length = 2;
                difference = A[i] - A[i - 1];
            }
        }
        // 如果最后的几个是等差数列，结果集中加上
        if (length >= 3) {
            length = length - 2;
            if (length % 2 == 0) {
                res += (length + 1) * (length / 2);
            } else {
                res += (length + 1) * (length - 1) / 2 + length / 2 + 1;
            }
        }
        return res;
    }

}
