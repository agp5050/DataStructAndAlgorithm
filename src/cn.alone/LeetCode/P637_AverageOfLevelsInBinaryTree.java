package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RojerAlone on 2017/7/9.
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 刷新了一下页面就多了一道题。。。
 * 求二叉树每一层的平均值
 */
public class P637_AverageOfLevelsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 同 513、515 题一样，广度优先遍历，但是每次遍历一层
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            double count = 0; // 某一层的和
            int nums = 0; // 某一层的结点个数
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (queue.isEmpty() == false) {
                TreeNode node = queue.pop();
                nums++;
                count += node.val;
                // 找出新一行的结点
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue.addAll(tmp);
            res.add(count / nums);
        }
        return res;
    }

}
