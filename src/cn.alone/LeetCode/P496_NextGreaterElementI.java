package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/next-greater-element-i/
 * 输入两个数组，第一个数组是第二个数组的子集
 * 求num1中的元素对应的num2中相同的元素在num2中右边第一个大于它的元素
 */
public class P496_NextGreaterElementI {

    /**
     * 直接暴力撸，时间复杂度为 O(m*n)
     * 可以进行优化，将 num2 中的数和对应的下标放入 map中
     * 对 num1 遍历时直接找到了在 num2 中对应的数的下标，然后开始遍历
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        boolean find = false;   // 用来标识是否找到了比 num1 中大的数
        for (int i = 0; i < findNums.length; i++) {
            boolean flag = false;   // 用来标识是否找到了在第二个数组中对应的数
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == findNums[i]) {
                    flag = true;
                    continue;
                }
                // 找到了这个数
                if (flag && nums[j] > findNums[i]) {
                    res[i] = nums[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                res[i] = -1;
            } else {
                find = false;
            }
        }
        return res;
    }

}
