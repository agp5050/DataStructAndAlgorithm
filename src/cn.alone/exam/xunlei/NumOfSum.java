package cn.alone.exam.xunlei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-19.
 * 给定两个整数 n 和 m，求出从 1 到 n 中可以组成和为 m 的组数（数字不能重复使用）
 */
public class NumOfSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        helper(n, new HashSet<Integer>(), m, 1);
        System.out.println(res);
    }

    private static int res = 0;

    private static void helper(int n, HashSet<Integer> set, int target, int cur) {
        if (target == 0) {
            res++;
            return;
        }
        for (int i = cur; i <= n; i++) {
            if (i > target) {
                break;
            }
            if (!set.contains(i)) {
                set.add(i);
                helper(n, set, target - i, i + 1);
                set.remove(i);
            }
        }
    }

}
