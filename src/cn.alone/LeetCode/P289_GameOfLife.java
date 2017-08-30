package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-30.
 * https://leetcode.com/problems/game-of-life/
 * 康威生命游戏
 * 生命游戏中，对于任意细胞，规则如下：
 * 每个细胞有两种状态-存活或死亡，每个细胞与以自身为中心的周围八格细胞产生互动。
 * <p>
 * 当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时， 该细胞变成死亡状态。（模拟生命数量稀少）
 * 当前细胞为存活状态时，当周围有2个或3个存活细胞时， 该细胞保持原样。
 * 当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
 * 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。 （模拟繁殖）
 * <p>
 * 可以把最初的细胞结构定义为种子，当所有在种子中的细胞同时被以上规则处理后, 可以得到第一代细胞图。按规则继续处理当前的细胞图，
 * 可以得到下一代的细胞图，周而复始。
 * <p>
 * 给定当前的状态，计算下次的状态
 */
public class P289_GameOfLife {

    /**
     * leetcode 中大神的思路  https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation
     * 用位来存储细胞的状态，高位表示下一次的状态，低位表示当前的状态，0 表示死亡，1 表示存活
     * 开始的时候，每个细胞要么是 00 要么是 01，最后计算下一次状态的时候，每一个细胞进行右移 1 位 >> 1 即可
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = liveNeighbors(board, rows, cols, i, j);

                // 开始的时候，每个细胞的下一次状态都是 0，即 01 或者 00
                // 因此只需要关心下一次会存活的情况
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // 设置下一次状态为存活 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // 设置下一次状态为存活 00 -> 10
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;  // 获取下一次状态
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

}
