package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-03.
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 判断树 A 和树 B 以当前根结点遍历是否是子树
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        // 先判断 root2
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }

}
