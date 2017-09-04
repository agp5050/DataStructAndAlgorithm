package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-04.
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        while (--length > 0) { // 当前树的根结点
            int index = 0;
            while (sequence[index] < sequence[length]) { // 找到右子树的起始节点
                index++;
            }
            while (sequence[index] > sequence[length]) { // 找到根节点
                index++;
            }
            if (index < length) { // 如果根节点不是最后的结点，返回 false
                return false;
            }
        }
        return true;
    }

}
