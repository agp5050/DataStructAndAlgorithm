package cn.alone.LeetCode;

import java.util.Random;

/**
 * Created by RojerAlone on 2017-08-12.
 * https://leetcode.com/problems/linked-list-random-node/
 * 没看懂。。。
 */
public class P382_LinkedListRandomNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode head;
    Random random;

    public P382_LinkedListRandomNode(ListNode h) {
        head = h;
        random = new Random();
    }

    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for (int i = 1; c.next != null; i++) {
            c = c.next;
            if (random.nextInt(i + 1) == i) r = c.val;
        }
        return r;
    }

}
