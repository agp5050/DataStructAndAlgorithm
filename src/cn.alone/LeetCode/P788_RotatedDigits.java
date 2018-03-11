package cn.alone.LeetCode;

/**
 * @author RojerAlone
 * @Date 2018-03-11 16:15
 * https://leetcode.com/problems/rotated-digits/
 * 如果将一个数字中的每一个数都旋转 180 度以后它变成了另一个数字，那么它是一个好数字
 * （其实好数字就是 2 5 6 9 和包含有它们但是不包含 3 4 7 的数字）
 * 给出一个数字，求从 1 到这个数字之间有多少个好数字
 */
public class P788_RotatedDigits {

    public int rotatedDigits(int n) {
        if (n < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            String num = String.valueOf(i);
            if ((num.contains("2") || num.contains("5") || num.contains("6") || num.contains("9"))
                    && !(num.contains("3") || num.contains("4") || num.contains("7"))) {
                ++res;
            }
        }
        return res;
    }

}
