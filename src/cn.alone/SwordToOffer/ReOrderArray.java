package cn.alone.SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RojerAlone on 2017-09-02.
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 牛客网上看到的
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) { // 前偶后奇交换
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 用一个队列记录偶数，遍历过程中遇到奇数，将奇数放在指定位置，偶数入队，最后将偶数出队并且加到奇数后边
     */
    public void reOrderArrayWithQueue(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int num : array) {
            if (num % 2 == 1) {
                array[index++] = num;
            } else {
                queue.offer(num);
            }
        }
        while (queue.isEmpty() == false) {
            array[index++] = queue.poll();
        }
    }

}
