package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-14
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 从链表中删除倒数第 n 个结点
 */
public class P019_RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return head;
        }
        ListNode node = head;
        while(--n != 0 && node != null) { // 先找到正数第 n 个结点
            node = node.next;
        }
        ListNode tmp = new ListNode(0); // 使用一个临时结点，可以处理删除的结点是头结点的情况，也可以处理删除的是尾结点的情况
        tmp.next = head;
        ListNode left = tmp;
        while (node.next != null) {
            node = node.next;
            left = left.next;
        }
        left.next = left.next.next;
        return tmp.next;
    }

}
