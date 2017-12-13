package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangrenjie on 2017-12-13
 * https://leetcode.com/problems/combination-sum/
 * 给定数组和一个目标值，找出数组元素的组合中和等于目标值的组合，每个元素可以使用多次（每个组合都可以有重复的数字）
 */
public class P039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return res;
        }
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmpRes, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) { // 跳过重复
                continue;
            }
            tmpRes.add(candidates[i]);
            helper(res, tmpRes, candidates, target - candidates[i], i); // 因为可以有重复的元素，所以 index 不变
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

}
