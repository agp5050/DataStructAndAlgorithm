package cn.alone.LeetCode;

import java.util.LinkedList;

/**
 * Created by RojerAlone on 2017/7/3.
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * 给一颗二叉树，返回这个树的最左、最低的叶子节点的值
 */
public class P513_FindBottomLeftTreeValue {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先遍历
     * 在每一个 while 循环中将队列中左右的结点出队（为了记录最左边的结点）
     * 同时将下一层的结点放入一个中转队列中，所有出队完了初始队列为空，再将所有中转队列中的结点放入初始队列中
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = root;   // 标记某一层的最左边的结点
        while (queue.isEmpty() == false) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            TreeNode newLeft = null;
            while (queue.isEmpty() == false) {
                TreeNode node = queue.pop();
                // 找出新一行最左边的结点
                if (node.left != null) {
                    tmp.add(node.left);
                    if (newLeft == null) {
                        newLeft = node.left;
                    }
                }
                if (node.right != null) {
                    tmp.add(node.right);
                    if (newLeft == null) {
                        newLeft = node.right;
                    }
                }
            }
            queue.addAll(tmp);
            if (newLeft != null) {
                left = newLeft;
            }
        }
        return left.val;
    }

}
