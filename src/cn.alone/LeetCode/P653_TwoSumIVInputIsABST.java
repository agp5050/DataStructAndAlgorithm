package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-09.
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * two sum 的变种，给一颗二叉搜索树以及目标值，找出是否存在两个结点的和为目标值
 */
public class P653_TwoSumIVInputIsABST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 先确定一个结点，然后二叉查找 （目标值 - 当前值），找不到再从左至右依次 dfs
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, root, k);
    }

    /**
     * dfs 查找
     */
    private boolean dfs(TreeNode root, TreeNode current, int k) {
        if (current == null) {
            return  false;
        }
        return find(root, current, k - current.val) || dfs(root, current.left, k) || dfs(root, current.right, k);
    }

    /**
     * 从二叉搜索树中找到目标值
     */
    private boolean find(TreeNode root, TreeNode current, int target) {
        if (root == null) {
            return false;
        }
        return (root.val == target && root != current)
                || (root.val < target && find(root.right, current, target))
                || (root.val > target && find(root.left, current, target));
    }

}
