package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-08.
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 给一颗二叉树，找出叶子结点中左叶子的和
 */
public class P404_SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
