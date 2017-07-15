package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017/7/15.
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 给定一个从大小为1到n，长度为n的整型数组，有的数字出现一次，有的出现两次
 * 找出没有出现的数字
 * 要求不使用额外空间，在 O(n)时间复杂度内找出
 */
public class P448_FindAllNumbersDisappearedInAnArray {

    /**
     * 和 P442_FindAllDuplicatesInAnArray 类似
     * 每遍历到一个数，让这个数对应的下标元素取反，如果是已经取过反了就不再取反
     * 最后找出大于0的数字的下标即可
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
