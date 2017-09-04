package cn.alone.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RojerAlone on 2017-09-04.
 * 从上往下打印二叉树
 */
public class PrintBinaryTreeFromTopToBottom {

    /**
     * 其实就是层序遍历，用队列存放每层的元素
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

}
