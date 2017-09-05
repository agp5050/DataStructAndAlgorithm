package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-05.
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneLinkedList {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 先在原链表中的后一个结点复制当前结点，然后再拆分
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        // 复制链表中的结点
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        // 复制随机结点，当前结点的下一个结点就是复制的结点，复制节点的随机结点就是当前结点的随机结点的下一个结点
        node = pHead;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        // 分裂链表
        RandomListNode head = pHead.next;
        RandomListNode newNode = head;
        node = pHead;
        node.next = node.next.next;
        node = node.next;
        while (node != null) {
            newNode.next = node.next;
            newNode = newNode.next;
            node.next = newNode.next;
            node = node.next;
        }
        return head;
    }

}
