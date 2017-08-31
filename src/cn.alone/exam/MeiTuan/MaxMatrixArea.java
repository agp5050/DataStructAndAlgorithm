package cn.alone.exam.MeiTuan;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 最大矩形面积
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积
 *
 * 输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
 * 第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
 *
 * 输出一个整数,表示最大的矩阵面积。
 */
public class MaxMatrixArea {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num]; // tmp[i][j] 表示 从 i 到 j 之间的最小值
        int max = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            arr[i][i] = sc.nextInt(); // 对角线上的数字为 第 i 个数字
            for (int j = 0; j < i; j++) { // 记录从 0 到 当前数字的最小值
                arr[j][i] = Math.min(arr[i][i], arr[j][i - 1]);
                max = Math.max(max, arr[j][i] * (i - j + 1)); // 比较最大面积
            }
            maxNum = Math.max(maxNum, arr[i][i]);
        }
        sc.close();
        max = Math.max(max, maxNum);
        System.out.println(max);
    }

}
