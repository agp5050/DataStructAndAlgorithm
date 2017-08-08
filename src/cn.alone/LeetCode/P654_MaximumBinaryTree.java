package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-08-08.
 * https://leetcode.com/problems/maximum-binary-tree/
 * 给定一个数组，返回一颗最大树
 * 最大树满足一下条件：
 * 1. 根节点是数组中最大的数
 * 2. 左子树是最大的数左边的数组成的最大树
 * 3. 右子树是最大的数右边的数组成的最大树
 */
public class P654_MaximumBinaryTree {

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) { // 找出最大值
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (index == nums.length - 1) {
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
            root.right = null;
            return root;
        } else {
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
            return root;
        }
    }

}
