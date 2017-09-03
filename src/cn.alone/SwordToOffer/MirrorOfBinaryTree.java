package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-03.
 * 二叉树的镜像，LeetCode 226 InvertBinaryTree
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorOfBinaryTree {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }

}
