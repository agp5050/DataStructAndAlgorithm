package cn.alone.exam.NetEasy;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-09.
 * 合唱
 * 小B 和牛博士 合唱，音调为 大于等于 1 的整数，每个人选取一部分音调唱，求排列组合使每两个音调的差之和最小
 */
public class Sing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        // 递归
//        helper(arr, 0, 1, arr[0], 0);
//        helper(arr, 0, 1, 0, arr[0]);
//        System.out.println(res);

        // 动态规划
        System.out.println(dp(arr, 0, 0));
    }

    private static int dp(int[] arr, int la, int lb) {
        int size = arr.length;
        int[][] dp = new int[size][size];

        int now = Math.max(la, lb) + 1;
        if (now == size + 1) return 0;
        if (dp[la][lb] != -1) return dp[la][lb];
        return dp[la][lb] = Math.min(dp(arr, now, lb) + (la > 0 ? Math.abs(arr[now] - arr[la]) : 0),
                dp(arr, la, now) + (lb > 0 ? Math.abs(arr[now] - arr[lb]) : 0));
    }

    private static int res = Integer.MAX_VALUE;

    /**
     * 递归，50%
     *
     * @param arr
     * @param cur   当前的难度和
     * @param index 当前遍历到哪里了
     * @param xiaoB 小B 当前的音调
     * @param boshi 牛博士的音调
     */
    private static void helper(int[] arr, int cur, int index, int xiaoB, int boshi) {
        if (index == arr.length) {
            res = Math.min(res, cur);
            return;
        }
        if (xiaoB == 0) {
            xiaoB = arr[index];
        }
        int tmp = cur + Math.abs(xiaoB - arr[index]);
        if (tmp < res) {
            helper(arr, tmp, index + 1, arr[index], boshi);
        }
        if (boshi == 0) {
            boshi = arr[index];
        }
        tmp = cur + Math.abs(boshi - arr[index]);
        if (tmp < res) {
            helper(arr, tmp, index + 1, xiaoB, arr[index]);
        }
    }

}
