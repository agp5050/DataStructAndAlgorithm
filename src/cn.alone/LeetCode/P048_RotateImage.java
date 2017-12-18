package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-18
 * https://leetcode.com/problems/rotate-image/
 * 给定 n×n 的矩阵，顺时针旋转 90 度
 */
public class P048_RotateImage {

    /**
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                swap(matrix, i, j, length - 1 - i, j);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length ; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

}
