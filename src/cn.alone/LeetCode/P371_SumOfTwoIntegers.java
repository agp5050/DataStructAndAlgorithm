package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/16.
 * https://leetcode.com/problems/sum-of-two-integers/
 * http://blog.csdn.net/alone_rojer/article/details/63260527
 * 不使用加号和减号计算两个数的和
 */
public class P371_SumOfTwoIntegers {

    /**
     * 先计算两个数相加以后不进位的值，保存这个进位的值，
     * 如5+7进位10，不进位为2，那么5^7的值就是2，
     * (5&7)<<1的值是10，然后把不进位的值和要进位的值相加即可。
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            // 得到二进制相加以后不进位的值，如5+7不进位的值是2
            int tmp = a ^ b;
            // 得到进位的值，如5+7进位的值是10
            b = (a & b) << 1;
            // a=tmp，如果不进位就返回num1
            a = tmp;
        }
        return a;
    }

}
