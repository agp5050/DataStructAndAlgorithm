package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-01.
 * https://leetcode.com/problems/minesweeper/
 * 扫雷游戏
 * 给定2维字符矩阵board，'M'表示未挖到的地雷，'E'表示未挖到的空地。'B'表示已经挖到的、四周（上下左右以及对角线）没有地雷的空地。
 * 数字'1'到'8'表示四周包含相应数字的地雷，'X'表示挖到地雷。
 * 给定下一次鼠标点击的位置（只在'M'或者'E'处点击），根据如下规则返回点击之后的board：
 * 1. 如果挖到'M'，则将其变成'X'，游戏结束
 * 2. 如果挖到四周没有地雷的'E'，将其变成'B'，并递归地挖开其相邻无雷区域
 * 3. 如果挖到四周包含地雷的'E'，将其替换为四周地雷的数目
 */
public class P529_Minesweeper {

    /**
     * 广度优先遍历
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0 || click == null || click.length != 2) {
            return board;
        }
        int rows = board.length; // 矩阵的行
        int cols = board[0].length; // 矩阵的列
        int x = click[0];
        int y = click[1];
        if (x >= rows || x < 0 || y >= cols || y < 0) {
            return board;
        }
        // 挖到炸弹，结束
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        // 遍历四周
        int count = 0; // 四周炸弹的数量
        int[] round = {-1, 0, 1};
        for (int i : round) {
            for (int j : round) {
                if (i == 0 && j == 0) { // 在原地
                    continue;
                }
                int r = x + i;
                int c = y + j;
                if (r < 0 || r >= rows || c < 0 || c >= cols) { // 越界
                    continue;
                }
                if (board[r][c] == 'M' || board[r][c] == 'X') {
                    count++;
                }
            }
        }
        if (count > 0) { // 四周有炸弹
            board[x][y] = (char) (count + '0');
            return board;
        }
        // 没有炸弹就找出更新没有炸弹的格子
        board[x][y] = 'B';
        for (int i : round) {
            for (int j : round) {
                if (i == 0 && j == 0) { // 在原地
                    continue;
                }
                int r = x + i;
                int c = y + j;
                if (r < 0 || r >= rows || c < 0 || c >= cols) { // 越界
                    continue;
                }
                if (board[r][c] == 'E') {
                    updateBoard(board, new int[]{r, c});
                }
            }
        }
        return board;
    }

}
