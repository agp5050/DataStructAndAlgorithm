package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/7/10.
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * 给定一颗二叉树，找出重复次数最多的子树和，如果有多个就返回多个
 * 子树和为当前结点值加上所有子结点的值的和
 */
public class P508_MostFrequentSubtreeSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map = new HashMap<>(); // 记录子树和以及出现的次数
    private int max = 0; // 记录重复出现最多的次数

    /**
     * 递归，用 map 当做词典，key 为子树和，value为出现的次数，同时需要一个数字来记录到底哪个和出现的次数最多
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        helper(root);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                res.add((Integer) entry.getKey());
            }
        }
        int[] tmp = new int[res.size()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = res.get(i);
        }
        return tmp;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val += helper(node.left) + helper(node.right);
        int times = map.getOrDefault(node.val, 0);
        map.put(node.val, times + 1);
        if (times + 1 > max) {
            max = times + 1;
        }
        return node.val;
    }

}
