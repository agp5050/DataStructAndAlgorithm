package cn.alone.LeetCode;

import java.util.Stack;

/**
 * Created by RojerAlone on 2017-08-18.
 * https://leetcode.com/problems/reverse-linked-list/
 * 翻转链表
 */
public class P206_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 两种方法，一种是入栈出栈，另一种是递归
     */
    public ListNode reverseListWithStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = head;
        while (stack.isEmpty() == false) {
            node.next = stack.pop();
            node = node.next;
            node.next = null;
        }
        return head;
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

}
