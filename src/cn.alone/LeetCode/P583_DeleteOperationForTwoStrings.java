package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-18.
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 给出两个字符串，每次只能删除一个字符，求最少多少次可以使两个字符串相同
 */
public class P583_DeleteOperationForTwoStrings {

    /**
     * 相当于 最长公共子序列，用 DP 动态规划
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int val = dp[length1][length2];
        return length1 - val + length2 - val;
    }

}
