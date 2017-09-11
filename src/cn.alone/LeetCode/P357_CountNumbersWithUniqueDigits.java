package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-09-11.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * 给定一个非负整数 n，找出 0 <= x < 10^2 中 除了 [11,22,33,44,55,66,77,88,99] 以外的数的个数
 */
public class P357_CountNumbersWithUniqueDigits {

    /**
     * f(1) = 10
     * f(2) = 9 * 9
     * f(3) = f(2) * 8 = 9 * 9 * 8
     * f(4) = f(3) * 7 = 9 * 9 * 8 * 7
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

}
