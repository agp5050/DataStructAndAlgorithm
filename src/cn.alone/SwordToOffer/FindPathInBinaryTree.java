package cn.alone.SwordToOffer;

import java.util.ArrayList;

/**
 * Created by RojerAlone on 2017-09-04.
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathInBinaryTree {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    private ArrayList<Integer> tmp = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        int next = target - root.val;
        if (next < 0) {
            return res;
        }
        tmp.add(root.val);
        if (next == 0 && root.left == null && root.right == null) { // 如果已经找到了，返回
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return res;
        }
        FindPath(root.left, next);
        FindPath(root.right, next);
        tmp.remove(tmp.size() - 1);
        return res;
    }

}
