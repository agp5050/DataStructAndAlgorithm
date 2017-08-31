package cn.alone.exam.ByteDance;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-26.
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和
 * 最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 * 输入
 * 第一行输入数组序列个数，第二行输入数组序列。
 * 输出
 * 输出数组经过计算后的最大值。
 *
 * 样例输入
 * 3
 * 6 2 1
 * 样例输出
 * 36
 * <p>
 * 输入
 * 7
 * 6 2 5 5 5 4 7
 * 输出
 * 104
 */
public class ByteDance_20170822_02 {

    /**
     * 创建二维数组，坐标 arrs[i][j] 表示 从 i 到 j 的最小值
     * 另一个数组 arrs2，坐标 arrs2[i][j] 表示 从 i 到 j 的和，然后比较最小值 * 和
     * 如 从 0 到 5 的最小值是从 0 到 4 的最小值再和第 5 个值比较
     * 从 0 到 5 的和是从 0 到 4 的和再加上第 5 个值
     * 这两个数组只用到了一半，而且是只用了右上角的一半，因此可以将两个数组合并，节省一半的空间
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Integer.MIN_VALUE;
        int[][] arrs = new int[n][n]; // 从 x 到 y 的最小值、和，右上角表示最小值，左下角表示和
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arrs[i][i] = num;
            for (int j = 0; j <= i; j++) { // 记录从 0 到 i 的最小值、和以及计算结果
                if (j == i) { // 如果是对角线上的数字，值是当前值
                    arrs[j][i] = num;
                } else {
                    arrs[j][i] = Math.min(num, arrs[j][i - 1]); // 0,1,2... 到 i 的最小值 为当前值和 0 到 i - 1 的最小值的更小的
                    // 用 n - 1 - j 转换坐标
                    if (j + 1 == i) { // 如果是 i - 1 到 i 的和，也就是当前值和上一个值的和
                        arrs[n - j - 1][n - i - 1] = num + arrs[j][j];
                    } else {
                        arrs[n - j - 1][n - i - 1] = num + arrs[n - j - 1][n - i]; // 和
                    }
                    res = Math.max(arrs[j][i] * arrs[n - j - 1][n - i - 1], Math.max(res, num * num)); // 最小值和 和 的乘积
                }
            }
        }
        sc.close();
        System.out.println(res);
    }

}
