package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-19.
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 二叉树的直径 二叉树的直径：二叉树中从一个结点到另一个节点最长的路径，叫做二叉树的直径
 */
public class P543_DiameterOfBinaryTree {

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
     * 根节点为root的二叉树的直径 = max(root-left的直径，root->right的直径，root->left的最大深度+root->right的最大深度+1)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dia = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(left, right));
    }

    /**
     * 二叉树的深度
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
