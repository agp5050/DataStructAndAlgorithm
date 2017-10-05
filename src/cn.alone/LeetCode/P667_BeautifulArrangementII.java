package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-10-05.
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 * 美丽数组，给两个整数 n 和 k，构造一个大小为 n，包含 1 到 n 的数组，并且构造的数组中每两个相邻的数的差恰好包含 k 个不同的整数
 */
public class P667_BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        if (n <= 0 || k >= n) {
            return null;
        }
        int[] arr = new int[n];
        int left = 1;
        int right = n;
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                arr[i] = left++;
            } else {
                arr[i] = right--;
            }
        }
        if (k % 2 == 1) {
            for (int i = left; i <= right; i++) {
                arr[k++] = i;
            }
        } else {
            for (int i = right; i >= left; i--) {
                arr[k++] = i;
            }
        }
        return arr;
    }

}
