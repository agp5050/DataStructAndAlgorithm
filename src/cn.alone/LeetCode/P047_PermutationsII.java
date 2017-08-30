package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-30.
 * https://leetcode.com/problems/permutations-ii/
 * P046_Permutations 的变种，给定数组中可能有重复数字
 */
public class P047_PermutationsII {

    List<List<Integer>> res = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp, boolean[] used) {
        if (nums.length == tmp.size()) { // 已经排列完了，结束
            res.add(new ArrayList<Integer>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) { // 已经使用过了，跳过
                    continue;
                }
                used[i] = true;
                tmp.add(nums[i]);
                helper(nums, tmp, used);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
