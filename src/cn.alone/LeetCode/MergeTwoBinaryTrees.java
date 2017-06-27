package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 输入两个二叉树，将两个二叉树合并，如果两个树的节点不为空，那么将节点值相加
 */
public class MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);
        return res;
    }

}
