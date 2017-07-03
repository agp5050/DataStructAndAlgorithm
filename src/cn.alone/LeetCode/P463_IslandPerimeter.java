package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/3.
 * https://leetcode.com/problems/island-perimeter/
 * 给一个矩阵，1表示是陆地，0表示海洋，计算陆地的边界有多少个
 */
public class P463_IslandPerimeter {

    /**
     * 先计算有多少块陆地，每两块陆地相邻边界就减少2个，用 陆地数 * 4 - 相邻数 * 2
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int island = 0;
        int neighbor = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return island * 4 - neighbor * 2;
    }

}
