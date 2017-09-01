package cn.alone.exam.MeiTuan;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-08-31.
 * 改卷子
 * 只需要判断人数最多的组是否有多个或者人数最多的组的人数是否超过一半即可
 */
public class MeiTuan_20170831_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        sc.close();
        helper(arr, max);
    }

    private static void helper(int[] arr, int max) {
        int num = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                num++;
            }
            sum += arr[i];
        }
        if (num > 1 || max * 2 <= sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
