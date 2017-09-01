package cn.alone.exam.MeiTuan;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 拼凑钱币
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 *
 * 输入包括一个整数n(1 ≤ n ≤ 10000)，输出一个整数,表示不同的组合方案数
 */
public class PutTogetherMoney {

    private static int res = 0;

    private static int[] moneys = {1, 5, 10, 20, 50, 100};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        sc.close();
        getKinds(money);
        System.out.println(res);
    }

    private static void getKinds(int money) {
        if (money < 0) {
            return;
        }
        if (money == 0) {
            res++;
            return;
        }
        for (int m : moneys) {
            if (m > money) {
                return;
            }
            getKinds(money - m);
        }
    }

}
