package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-12.
 * https://leetcode.com/problems/add-one-row-to-tree/
 * 给一颗二叉树和层数d,数字v，在树的第 d 层添加一层，所有的数字都是 v
 */
public class P623_AddOneRowToTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null || d < 1) {
            return root;
        }
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        List<TreeNode> list = new ArrayList<>(); // 要增加的层的上一层
        list.add(root);
        int level = 1;
        while (level < d - 1) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : list) { // 记录下一层
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            list.clear();
            list.addAll(tmp);
            level++;
        }
        for (TreeNode node : list) { // 添加一层
            TreeNode left = new TreeNode(v);
            if (node.left != null) {
                left.left = node.left;
            }
            node.left = left;
            TreeNode right = new TreeNode(v);
            if (node.right != null) {
                right.right = node.right;
            }
            node.right = right;
        }
        return root;
    }

}
