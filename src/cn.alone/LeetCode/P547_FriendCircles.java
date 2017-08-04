package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/friend-circles/
 * 求朋友圈个数，如果 A 和 B 是直接好友（矩阵中 M[i][j] == M[j][i]，那么 i 和 j 是直接好友），B 和 C 不是直接好友，
 * 那么 A、B、C 是一个朋友圈。
 */
public class P547_FriendCircles {

    /**
     * 深度优先遍历，是遍历过的设置标识（一个人只能属于一个朋友圈）
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

}
