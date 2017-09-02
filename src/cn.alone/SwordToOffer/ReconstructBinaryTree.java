package cn.alone.SwordToOffer;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-09-01.
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class ReconstructBinaryTree {

    /**
     * 递归
     * 前序遍历是根节点在前，然后依次是左右结点
     * 中序遍历是先左结点再根节点再右结点
     * 根据这个性质，在中序遍历中找到根节点位置，左边的部分就是左子树，右边的部分就是右子树，然后递归
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        } else if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        for (i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
        return root;
    }

}
