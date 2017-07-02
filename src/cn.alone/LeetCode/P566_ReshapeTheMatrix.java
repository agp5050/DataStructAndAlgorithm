package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/reshape-the-matrix/
 * 给定二维矩阵nums，将其转化为r行c列的新矩阵。若无法完成转化，返回原矩阵。
 */
public class P566_ReshapeTheMatrix {

    /**
     * 遍历初始矩阵，同时记录结果矩阵的行列数，如果该换行的话就换行
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int rows = nums.length;    // 行数
        int cols = nums[0].length; // 列数
        int rr = 0; // 结果矩阵的行坐标
        int rc = 0; // 结果矩阵的列坐标
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rc == c) {
                    rc = 0;
                    rr++;
                }
                res[rr][rc] = nums[i][j];
                rc++;
            }
        }
        return res;
    }

}
