package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/hamming-distance/
 * 汉明距离，将两个数异或，求出异或后二进制中1的位数
 */
public class P461_HammingDistance {

    public int hammingDistance(int x, int y) {
        int res = 0;
        // 异或
        int tmp = x ^ y;
        // 每次将 tmp 和 tmp - 1 相与
        // 如 0101 & 0100 = 0100
        //    0100 & 0011 = 0000
        // 相当于每次去除了一个1
        while (tmp > 0) {
            res++;
            tmp = tmp & (tmp - 1);
        }
        return res;
    }

}
