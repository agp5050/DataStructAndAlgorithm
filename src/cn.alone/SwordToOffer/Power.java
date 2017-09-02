package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    /**
     * 每次将指数右移一位 （指数 / 2），然后结果 * 底数^2 ，如果最后一位为 1，那么结果需要多乘一次
     * 2^5  exponent = 5 -> 101
     * res = 2  current = 4     exponent = 2 -> 10
     *          current = 16    exponent = 1 -> 1
     * res = res * current = 2 * 16 = 32    exponent = 0
     * return 32
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (base == 1 || exponent == 0) {
            return 1;
        }
        boolean flag = false; // 记录次方是否是负数
        if (exponent < 0) {
            exponent *= -1;
            flag = true;
        }
        double res = 1;
        double current = base;
        while (exponent != 0) {
            if ((exponent & 1) == 1) { // 如果最后一位为 1
                res *= current;
            }
            // 乘以 ^2，然后右移一位表示指数 / 2
            current *= current;
            exponent >>= 1;
        }
        return flag ? 1 / res : res;
    }

}
