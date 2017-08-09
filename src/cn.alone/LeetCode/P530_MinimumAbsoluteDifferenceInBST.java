package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-09.
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 找出二叉搜索树中结点差的最小绝对值
 */
public class P530_MinimumAbsoluteDifferenceInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = Integer.MAX_VALUE;
    private Integer pre = null; // 记录中序遍历左边的值

    /**
     * 如果是层序遍历，只需要比较相邻两个数的值即可，但是是一颗二叉搜索树，如果中序遍历之后再比较效率低下，可以在遍历过程中比较
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return res;
        }
        getMinimumDifference(root.left); // 遍历到最左边才会结束
        if (pre != null) {
            res = Math.min(res, root.val - pre); // 和左边的值比较
        }
        pre = root.val;
        getMinimumDifference(root.right);
        return res;
    }

}
