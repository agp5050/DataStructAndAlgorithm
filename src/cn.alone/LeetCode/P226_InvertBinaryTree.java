package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/16.
 * https://leetcode.com/problems/invert-binary-tree/
 * 给一颗二叉树，将左右结点互换
 */
public class P226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
