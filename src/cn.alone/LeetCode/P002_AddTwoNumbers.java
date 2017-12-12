package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-12
 * https://leetcode.com/problems/add-two-numbers/
 * 给定两个非空链表，表示两个非负整数，每位的数字以相反的顺序存储，每个结点存储一个数字，计算两个数的和并且同样以链表形式返回
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class P002_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        boolean up = false; // 是否进位
        if (sum >= 10) {
            up = true;
        }
        ListNode res = new ListNode(sum % 10);
        ListNode cur = res;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            if (up) {
                sum += 1;
                up = false;
            }
            if (sum >= 10) {
                up = true;
            } else {
                up = false;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                if (up) {
                    sum = l2.val + 1;
                } else {
                    sum = l2.val;
                }
                if (sum >= 10) {
                    up = true;
                } else {
                    up = false;
                }
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = node;
                l2 = l2.next;
            }
        }
        if (l1 != null && l2 == null) {
            while (l1 != null) {
                if (up) {
                    sum = l1.val + 1;
                } else {
                    sum = l1.val;
                }
                if (sum >= 10) {
                    up = true;
                } else {
                    up = false;
                }
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = node;
                l1 = l1.next;
            }
        }
        if (up) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return res;
    }

    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

}
