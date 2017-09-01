package cn.alone.exam.MeiTuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 元素和能被 K 整除的子串的最大长度
 *
 * 序列中任意个连续的元素组成的子序列称为该序列的子串。
 * 现在给你一个序列P和一个整数K，询问元素和是K的倍数的子串的最大长度。
 * 比如序列【1,2,3,4,5】，给定的整数K为 5，其中满足条件的子串为{5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
 * 那么答案就为 5，因为最长的子串为{1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
 *
 * 输入：
 *
 * 第一含一个整数N, 1 ≤ 𝑁 ≤ 105 。
 * 第二行包含 N 个整数𝑝𝑖 ，𝑝𝑖 表示序列P第i个元素的值。0 ≤ 𝑝𝑖 ≤ 105 。
 * 第三行包含一个整数 K， 1 ≤ 𝐾 ≤ 105 。
 */
public class MeiTuan_20170831_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] sum = new int[num]; // 前 i 个数的和
        sum[0] = sc.nextInt();
        for (int i = 1; i < num; i++) {
            sum[i] = sc.nextInt() + sum[i - 1];
        }
        int target = sc.nextInt();
        sc.close();
        Map<Integer, Integer> map = new HashMap<>(); // 记录前 i 个数取模后的值以及对应的 i
        int res = 0;
        // 如果前 i 个数取模为 n，前 j 个数取模也为 n，那么 j - i 之间的和取模为 0
        for (int i = 0; i < num; i++) {
            int tmp = sum[i] % target;
            if (tmp == 0) {
                res = Math.max(res, i + 1);
            }
            if (map.get(tmp) == null) {
                map.put(tmp, i);
            } else {
                res = Math.max(i - map.get(tmp), res);
            }
        }
        System.out.println(res);
    }

}
