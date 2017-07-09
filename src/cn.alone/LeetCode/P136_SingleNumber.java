package cn.alone.LeetCode;

import java.util.HashSet;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/single-number/
 * 给一个数组，每个数字出现两次只有一个数字只出现了一次，求这个数字
 */
public class P136_SingleNumber {

    /**
     * 利用二进制数字异或的特征，一个数字异或自己结果为0，
     * 遍历数组，依次异或，最后的结果就是只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
