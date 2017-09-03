package cn.alone.SwordToOffer;

import java.util.ArrayList;

/**
 * Created by RojerAlone on 2017-09-03.
 */
public class PrintMatrixInCircle {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0; // 记录当前遍历开始的坐标
        while (start * 2 < cols && start * 2 < rows) {
            helper(matrix, rows, cols, start);
            start++;
        }
        return res;
    }

    private ArrayList<Integer> res = new ArrayList<>();

    private void helper(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            res.add(matrix[start][i]);
        }
        // 从上到下打印一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }
        // 从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                res.add(matrix[i][start]);
            }
        }
    }

}
