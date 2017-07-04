package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by RojerAlone on 2017/7/4.
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 给定一个数组，每个数的大小在1和数组大小之间，某些数出现两次，某些数出现一次，找出数组中出现两次的数字
 */
public class P442_FindAllDuplicatesInAnArray {

    /**
     * 讨论区看到
     * 思想是：既然每个数的大小不大于数组的大小，那么可以将每一个遍历过的数字对应下标的数取反
     * 如果遍历到一个数，这个数对应的下标是小于0的，那么证明这个数出现过
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }

//        用了额外的空间，不符合要求
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                res.add(num);
//            } else {
//                set.add(num);
//            }
//        }
        return res;
    }

}
