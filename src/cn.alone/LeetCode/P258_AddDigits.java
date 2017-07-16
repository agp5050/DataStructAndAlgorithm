package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/16.
 * https://leetcode.com/problems/add-digits/
 * 给一个无符号整数，比如38，3+8=11,1+1=2，返回2
 */
public class P258_AddDigits {

    /**
     * 又是找规律的题。。。。。。
     */
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

}
