package cn.alone.exam.MeiTuan;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 大富翁
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。
 * 求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * 输入包括一个整数n,(1 ≤ n ≤ 6)
 * 输出一个整数,表示投骰子的方法
 */
public class BigRicher {

    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        getKinds(num);
        System.out.println(res);
    }

    private static void getKinds(int num) {
        if (num < 0 || num > 6) {
            return;
        }
        if (num == 0) {
            res++;
            return;
        }
        for (int i = 1; i <= num; i++) {
            getKinds(num - i);
        }
    }

}
