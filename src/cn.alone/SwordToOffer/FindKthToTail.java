package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 链表中倒数第 k 个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    /**
     * 先找到第 k 个结点，然后另一个指针指向头结点，两个结点一起后移直到第一个结点到尾部，此时第二个结点就是倒数第 k 个结点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode node = head;
        for (int i = 0; i < k - 1; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        ListNode tmp = head;
        while (node.next != null) {
            node = node.next;
            tmp = tmp.next;
        }
        return tmp;
    }

}
