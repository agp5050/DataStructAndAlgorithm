package cn.alone.SwordToOffer;

import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-03.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseLinkedList {

    /**
     * 用栈实现反转
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode node = head;
        while (stack.isEmpty() == false) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return head;
    }

}
