package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-14
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 合并两个排序过的链表
 */
public class P021_MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode node = res;
        if (l1.val <= l2.val) {
            res.val = l1.val;
            l1 = l1.next;
        } else {
            res.val = l2.val;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;
            }
        }
        return res;
    }

}
