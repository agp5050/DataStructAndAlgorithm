package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/counting-bits/
 * 给一个数字，计算从0到这个数字，每个数字的二进制中有多少个1，返回一个数组
 * 比如：5，返回 [0, 1, 1, 2, 1, 2]，因为0, 1, 2, 3, 4, 5 的二进制分别有0, 1, 1, 2, 1, 2 个1
 * 思路（来自 LeetCode Discuss ）：
 *      1111 相比于 111 多了一个1，1110 相比于 111 1的个数相同
 *      根据这个特性，只需要判断最后一位是不是1即可
 */
public class P338_CountingBits {

    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
