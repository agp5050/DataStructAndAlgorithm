package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/battleships-in-a-board/
 * 以前在哪里碰到过，找了找没找到，重新写一遍
 */
public class P419_BattleshipsInABoard {

    /**
     * 简单解法
     * 如果X的左边或者上边是X，证明这个位置是整个战舰的一部分，继续遍历，否则结果+1
     */
    public int countBattleshipsOfSimple(char[][] board) {
        // 输入合法性判断
        if (board == null || board.length == 0) {
            return 0;
        }
        int res = 0;
        int rows = board.length;    // 行数
        int cols = board[0].length; // 列数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 深度优先解法
     */
    public int countBattleshipsOfDFS(char[][] board) {
        // 输入合法性判断
        if (board == null || board.length == 0) {
            return 0;
        }
        int res = 0;
        int rows = board.length;    // 行数
        int cols = board[0].length; // 列数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 找到战舰的开头，那么结果+1，然后将这个战舰的其他部分变为 '.'
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 深度优先遍历，如果当前是战舰的一部分，那么就将此处字符设置为 '.'，然后继续深度遍历
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
    }

}
