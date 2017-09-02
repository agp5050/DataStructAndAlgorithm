package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    /**
     * (n - 1) & n 可以去除一个 1
     */
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            ++num;
            n = (n - 1) & n;
        }
        return num;
    }

}
