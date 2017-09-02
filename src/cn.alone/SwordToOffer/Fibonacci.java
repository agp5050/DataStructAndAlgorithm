package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 斐波那契数列
 * 输入一个整数n，输出斐波那契数列的第n项。
 * n<=39
 */
public class Fibonacci {

    public int Fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // F(n) = F(n - 2) + F(n - 1)
        int one = 0;
        int two = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

}
