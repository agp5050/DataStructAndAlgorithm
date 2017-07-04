package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RojerAlone on 2017/7/4.
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * 给定一颗二叉树，找出每一层最大的数
 */
public class P515_FindLargestValueInEachTreeRow {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 和 513题 FindBottomLeftTreeValue 类似，广度优先遍历，每次直接遍历一整层同时找到最大值
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            int max = Integer.MIN_VALUE;   // 标记某一层的最大值
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (queue.isEmpty() == false) {
                TreeNode node = queue.pop();
                if (node.val > max) {
                    max = node.val;
                }
                // 找出新一行最左边的结点
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue.addAll(tmp);
            res.add(max);
        }
        return res;
    }

}
