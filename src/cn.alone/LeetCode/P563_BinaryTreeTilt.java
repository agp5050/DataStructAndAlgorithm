package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-12.
 * https://leetcode.com/problems/binary-tree-tilt/
 * 求树的倾斜值，倾斜值是左右子树的倾斜值差的绝对值，如果结点没有子树，倾斜值为 0
 * 注意，子树的倾斜值是子结点差的绝对值加上他们本身
 */
public class P563_BinaryTreeTilt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }

}
