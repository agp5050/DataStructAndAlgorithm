package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/range-addition-ii/
 * 给定 m * n 矩阵 M，初始为 0，然后执行一些更新操作。
 * 数组 ops 表示一组更新操作，每一个操作(a, b)，表示将矩阵 0 <= i < a 并且 0 <= j < b的区域值 +1。
 * 进行若干操作后，求矩阵的最大值的个数。
 */
public class P598_RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        // 如果不进行操作，那么最大值就是矩阵本身
        if (ops == null || ops.length == 0 || ops[0].length == 0) {
            return m * n;
        }
        // 否则操作的共同部分就是最大值所在的部分
        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;
        for (int[] op : ops) {
            row = Math.min(op[0], row);
            col = Math.min(op[1], col);
        }
        return row * col;
    }

}
