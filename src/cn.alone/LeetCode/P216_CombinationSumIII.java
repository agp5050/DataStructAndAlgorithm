package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-26.
 * https://leetcode.com/problems/combination-sum-iii/
 * 给定数字 k 和 n
 * 找出大小为 k，内容为 从 1 到 9 的任意数字但是不能重复使用并且这 k 个数字的和为 n 的数组
 */
public class P216_CombinationSumIII {

    /**
     * 递归
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > 9) {
            return res;
        }
        helper(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    /**
     * 辅助函数，用来递归寻找合适的值
     * @param res 结果
     * @param tmp 当前寻找到的组合
     * @param k 要求数组的大小
     * @param start 从哪一个数开始寻找
     * @param n 当前还需要多大的数
     */
    private void helper(List<List<Integer>> res, List<Integer> tmp, int k, int start, int n) {
        if (tmp.size() == k && n == 0) { // 如果已经有 k 个数同时和为 n，结束
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            helper(res, tmp, k, i + 1, n - i);
            tmp.remove(tmp.size() - 1); // 找过以后去掉最后一个，继续找
        }
    }

}
