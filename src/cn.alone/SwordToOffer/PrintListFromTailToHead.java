package cn.alone.SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-01.
 * 从尾到头打印链表，输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {

    /**
     * 用栈实现，入栈再出栈
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = listNode;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (stack.isEmpty() == false) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 递归实现
     */
    public ArrayList<Integer> printListFromTailToHead_recursion(ListNode listNode) {
        res = new ArrayList<Integer>();
        if (listNode == null) {
            return res;
        }
        helper(listNode);
        return res;
    }

    private ArrayList<Integer> res;

    private void helper(ListNode listNode) {
        if (listNode.next != null) {
            helper(listNode.next);
        }
        res.add(listNode.val);
    }

}
