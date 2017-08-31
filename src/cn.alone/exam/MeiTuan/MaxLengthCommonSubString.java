package cn.alone.exam.MeiTuan;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 最长公共连续子串
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 */
public class MaxLengthCommonSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();
        System.out.println(maxLength(str1, str2));
    }

    /**
     * 动态规划
     */
    private static int maxLength(String str1, String str2) {
        int m, n;
        if (str1 == null || (m = str1.length()) == 0 || str2 == null || (n = str2.length()) == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = str1.charAt(i) == str2.charAt(j) ? 1 : 0;
                } else {
                    dp[i][j] = str1.charAt(i) == str2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

}
