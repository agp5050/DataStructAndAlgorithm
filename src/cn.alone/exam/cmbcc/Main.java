package cn.alone.exam.cmbcc;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-13.
 * 招商银行信用卡中心
 * 给定 3 个正整数 a，b，n，求 a 和 b 的不大于 n 的公倍数的个数
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        int start = Math.max(a, b);
        int tmp = 0; // 记录两个数的最小公倍数
        for (int i = start; i <= n; i++) {
            if (i % a == 0 && i % b == 0) {
                tmp = i;
                break;
            }
        }
        if (tmp == 0) {
            System.out.println(0);
        } else {
            System.out.println(n / tmp); // 上限除以最小公倍数就是公倍数的个数
        }
    }

}
