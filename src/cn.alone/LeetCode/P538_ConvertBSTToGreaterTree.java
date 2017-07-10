package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/10.
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 将一颗搜索二叉树转化为更大的树，
 * 对于每个结点，要求计算出所有比它的值大的结点的值的和，并且将这个计算出来的和加到该结点上面
 */
public class P538_ConvertBSTToGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用二叉搜索树的性质，右边的树比左边的树的结点值都大
     * 递归，先遍历右子树，结果值加上当前结点的值即可
     */
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private int sum = 0;

    private void helper(TreeNode currennt) {
        if (currennt == null) {
            return;
        }
        helper(currennt.right);
        currennt.val += sum;
        sum = currennt.val;
        helper(currennt.left);
    }

}
