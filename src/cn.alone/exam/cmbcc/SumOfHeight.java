package cn.alone.exam.cmbcc;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-13.
 * 招商银行信用卡中心
 * A 和 B 从队伍中挑人，数组表示当前人的身高并且不重复，每人每次只能挑一个或者两个人，比较最后两个人挑的人的身高和
 * A 先开始，判断 A 是否能赢
 */
public class SumOfHeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();
        if (helper(arr, 0, 0, 0, 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static int sum = 0; // 记录身高和，只要 A 挑选的和大于身高和的一半，就结束

    /**
     * 递归，过了 60%
     * @param arr
     * @param a 当前 a 选的身高和
     * @param b
     * @param cur 当前该谁挑人了，a 为 0，b 为 1
     * @param index 当前该挑第几个人了
     * @return
     */
    private static boolean helper(int[] arr, int a, int b, int cur, int index) {
        if (a * 2 > sum) { // a 的身高和大于总身高和的一半，直接结束
            return true;
        }
        if (index >= arr.length) {
            return a >= b;
        }

        if (arr.length - index >= 2) { // 如果可以挑两个人
            if (cur == 0) {
                return helper(arr, a + arr[index], b, 1, index + 1) || helper(arr, a + arr[index] + arr[index + 1], b, 1, index + 2);
            } else {
                return helper(arr, a, b + arr[index], 0, index + 1) || helper(arr, a, b + arr[index] + arr[index + 1], 0, index + 2);
            }
        } else {
            if (cur == 0) {
                return helper(arr, a + arr[index], b, 1, index + 1);
            } else {
                return helper(arr, a, b + arr[index], 0, index + 1);
            }

        }
    }

}
