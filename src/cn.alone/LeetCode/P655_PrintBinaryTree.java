package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-09.
 * https://leetcode.com/problems/print-binary-tree/
 * 打印二叉树
 * Input:
 * 1
 * /
 * 2
 * Output:
 * [["", "1", ""],
 * ["2", "", ""]]
 *
 * Input:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * Output:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 */
public class P655_PrintBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 先获取树的深度，确定列数，再层序遍历
     */
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        int height = getHeight(root);
        int rows = height;
        int cols = (int) (Math.pow(2, height) - 1);
        List<List<String>> res = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>(row));
        }
        helper(root, res, 0, rows, 0, cols - 1);
        return res;
    }

    private void helper(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i + j) / 2, Integer.toString(root.val));
        helper(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        helper(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
