package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/10.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 求二叉树的深度
 */
public class P104_MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归，也可以用DFS，但是代码较为复杂
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
