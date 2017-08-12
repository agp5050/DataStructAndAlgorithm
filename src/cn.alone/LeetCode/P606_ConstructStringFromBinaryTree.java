package cn.alone.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by RojerAlone on 2017/7/15.
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * 从二叉树中构造一个字符串
 * Input: Binary tree: [1,2,3,4]
 *   1
 * /   \
 * 2     3
 * /
 * 4
 *
 * Output: "1(2(4))(3)"
 * 如果一个结点的右边的兄弟节点没有，那么不用写括号
 * Input: Binary tree: [1,2,3,null,4]
 *    1
 * /   \
 * 2     3
 * \
 * 4
 * Output: "1(2()(4))(3)"
 */
public class P606_ConstructStringFromBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 两种方法，一种递归，一种DFS
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    public String tree2strDFS(TreeNode t) {
        if (t == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();  // 存放所有的结点
        Set<TreeNode> visited = new HashSet<>(); // 存放访问过的结点
        stack.push(t);
        String res = "";
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.peek(); // 每次不出栈，如果这个结点访问过再出栈，为了加上右括号
            if (visited.contains(node)) {
                stack.pop();
                res += ")";
            } else {
                visited.add(node);
                res += "(" + node.val;
                if (node.left == null && node.right != null) {
                    res += "()";
                }
                // 先加入右边的结点，因为栈先进后出
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return res.substring(1, res.length() - 1); // (res) -> res
    }

}
