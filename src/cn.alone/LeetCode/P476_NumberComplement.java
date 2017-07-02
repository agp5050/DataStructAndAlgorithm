package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/number-complement/
 * 求一个数的二进制每一位取反后的数
 * 运用异或的特性,101 ^ 111 = 010
 * 任意数字和n个1的二进制异或，相当于每一位取反
 */
public class P476_NumberComplement {

    public int findComplement(int num) {
        int res = num;
        int tmp = 1;
        // 每循环一次，tmp乘2
        while (num > 0) {
            tmp <<= 1;
            num >>= 1;
        }
        return res ^ (tmp - 1);
    }

}
