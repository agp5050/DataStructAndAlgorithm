package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/4.
 * https://leetcode.com/problems/optimal-division/
 * 输入一个数组，用除号连接所有的数组成算式，在算式中添加括号使得结果最大，返回这样的字符串
 */
public class P553_OptimalDivision {

    /**
     * 1000 /(100/10/2) == (1000*10*2)/(100)
     * 第二个及以后的数字加上括号即可
     */
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        } else if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        String tail = "";
        for (int i = 1; i < nums.length; i++) {
            tail += nums[i] + "/";
        }
        return nums[0] + "/(" + tail.substring(0, tail.length() - 1) + ")";
    }

}
