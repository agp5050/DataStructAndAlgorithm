package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-30.
 * https://leetcode.com/problems/permutations/
 * 给定一个没有重复数字的数组，找出能组成的组合
 */
public class P046_Permutations {

    List<List<Integer>> res = null;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp) {
        if (nums.length == tmp.size()) { // 已经排列完了，结束
            res.add(new ArrayList<Integer>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i])) { // 已经排列过了，跳过
                    continue;
                }
                tmp.add(nums[i]);
                helper(nums, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
