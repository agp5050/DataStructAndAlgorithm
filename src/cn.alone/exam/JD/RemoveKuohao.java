package cn.alone.exam.JD;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-08.
 * 给定合法的字符串括号，每次清除左边第一个 ( ，然后清除右边一个 ) 使得字符串序列仍然合法
 * 请问有多少种方式清除完所有的括号
 */
public class RemoveKuohao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(remove(str));
    }

    private static int remove(String str) {
        int res = 1;
        int cur = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                cur++;
            } else {
                res *= cur;
                cur--;
            }
        }
        return res;
    }

}
